package com.magister.slim.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magister.slim.entity.Offering;
import com.magister.slim.entity.Resource;
import com.magister.slim.entity.StudyGuide;
import com.magister.slim.entity.Unit;
import com.magister.slim.entity.User;
import com.magister.slim.references.OfferingLevelReference;
import com.magister.slim.references.ResourceReference;
import com.magister.slim.references.StudyGuideReference;
import com.magister.slim.references.TeacherReference;
import com.magister.slim.references.UnitReference;
import com.magister.slim.repository.ResourceInterface;
import com.magister.slim.repository.StudyGuideInterface;
import com.magister.slim.repository.UnitInterface;

@Service
public class ResourceAppService {

	@Autowired
	ResourceInterface resourceInterface;
	@Autowired
	StudyGuideInterface studyGuideInterface;
	@Autowired
	UnitInterface unitInterface;

	public List<Resource> getResources(String resourceName) {
		if (resourceInterface.getResources(resourceName).isEmpty())
			return null;
		else {
			List<Resource> resources = resourceInterface.getResources(resourceName);
			return resources;
		}
	}
	
	public List<Resource> getResources(User user) {
		if (resourceInterface.findAll().isEmpty())
			return null;
		else {
			List<Resource> resources = resourceInterface.findAll();
			for(int i=0;i<resources.size();i++)
			{
				if(user.getUserid().equals(resources.get(i).getCreatedBy().getTeacherid())&&resources.get(i).isActive()==true) {}
				else
					resources.remove(i);
			}
			return resources;
		}
	}
	
	
	public Resource addToUnit(Unit unit1,Resource resource){
		Unit unit=unitInterface.findById(unit1.getUnitId()).get();
		resource.setStudyGuideReference(new StudyGuideReference(unit.getStudyGuideReference().getStudyGuideId()
				,unit.getStudyGuideReference().getStudyGuideName(),unit.getStudyGuideReference().isActive()));
		resourceInterface.save(resource);
		List<ResourceReference> resources = new ArrayList<ResourceReference>();
		if(unit!=null)
		{
		resources = unit.getResources();
		if (resources == null)
			resources = new ArrayList<ResourceReference>();
		resources.add(new ResourceReference(resource.getResourceId(),resource.getResourceType(),resource.getResourceName()));
		unit.setResources(resources);
		unitInterface.save(unit);
		}
		return resource;
	}

	public Resource deleteResource(String resourceId) {
		Resource resource = resourceInterface.findById(resourceId).get();
		if (resource.getStudyGuideReference() != null) {
			return null;
		} else {
			resource.setActive(false);
			resourceInterface.save(resource);
			return resource;
		}
	}

	public Resource addResource(Resource resource,User user) {
		resource.setCreatedBy(teacherDetails(user.getUserid(), user.getUsername()));
		resourceInterface.save(resource);
		return resource;
	}
	
	public TeacherReference teacherDetails(String id, String teacherName) {
		TeacherReference teacherReference = new TeacherReference();
		teacherReference.setTeacherid(id);
		teacherReference.setName(teacherName);
		teacherReference.setActive(true);
		return teacherReference;
	}
//
//	public StudyGuideReference studyGuideDetails(int id, String studyGuideName) {
//		StudyGuideReference studyGuideReference = new StudyGuideReference();
//		studyGuideReference.setStudyGuideId(id);
//		studyGuideReference.setStudyGuideName(studyGuideName);
//		return studyGuideReference;
//	}

	public Resource getResource(String resourceid) {
		if (resourceInterface.findById(resourceid).isPresent()) {
			Resource resource = resourceInterface.findById(resourceid).get();
			return resource;
		} else
			return null;
	}

	public Resource updateResource(String resourceId, Resource resource2) {
		Resource resource=resourceInterface.findById(resourceId).get();
		resource.setResourceName(resource2.getResourceName());
		resource.setResourceType(resource2.getResourceType());
		resourceInterface.save(resource);
		if(resource.getStudyGuideReference()!=null)
		{
			StudyGuide studyGuide=studyGuideInterface.findById(resource.getStudyGuideReference().getStudyGuideId()).get();
			List<UnitReference> unitReferences1 = studyGuide.getUnits().stream().map(unitReference -> {
				Unit unit=unitInterface.findById(unitReference.getUnitId()).get();
				List<ResourceReference> resourceReferencce =(List<ResourceReference>) unit.getResources().stream().map(resourceReference->{
					if(resourceReference.getResourceId().equals(resourceId)) {
					resourceReference.setResourceName(resource.getResourceName());
					resourceReference.setResourceType(resource.getResourceType());
					}
					return resourceReference;
				}).collect(Collectors.toList());
				unit.setResources(resourceReferencce);
				unitInterface.save(unit);
				return unitReference;
			}).collect(Collectors.toList());
			studyGuide.setUnits(unitReferences1);
			studyGuideInterface.save(studyGuide);
		}
		return resource;
	}
}
