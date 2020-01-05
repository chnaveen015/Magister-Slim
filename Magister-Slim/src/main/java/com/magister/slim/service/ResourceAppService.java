package com.magister.slim.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.magister.slim.entity.Resource;
import com.magister.slim.entity.StudyGuide;
import com.magister.slim.entity.Unit;
import com.magister.slim.entity.User;
import com.magister.slim.references.ResourceReference;
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
	UnitInterface unitInerface;

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
				if(user.getUserid().equals(resources.get(i).getCreatedBy().getTeacherid())) {}
				else
					resources.remove(i);
			}
			return resources;
		}
	}

	public String deleteResource(String resourceId) {
		String status = null;
		Resource resource = resourceInterface.findById(resourceId).get();
		if (resource.getStudyGuideReference() != null) {
			status = "You can't delete the resource as it is under StudyGuide Reference.You need to first delete in StudyGuide";
		} else {
			resource.setActive(false);
			resourceInterface.save(resource);
			status = "Successfully deleted";
		}
		return status;
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
				Unit unit=unitInerface.findById(unitReference.getUnitId()).get();
				List<ResourceReference> resourceReferencce =(List<ResourceReference>) unit.getResources().stream().map(resourceReference->{
					if(resourceReference.getResourceId().equals(resourceId)) {
					resourceReference.setResourceName(resource.getResourceName());
					resourceReference.setResourceType(resource.getResourceType());
					}
					return resourceReference;
				}).collect(Collectors.toList());
				unit.setResources(resourceReferencce);
				unitInerface.save(unit);
				return unitReference;
			}).collect(Collectors.toList());
			studyGuide.setUnits(unitReferences1);
			studyGuideInterface.save(studyGuide);
		}
		return resource;
	}
}
