package com.magister.slim.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.magister.slim.entity.Resource;
import com.magister.slim.entity.User;
import com.magister.slim.references.TeacherReference;
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

	public List<Resource> getResource(User user) {
		if (resourceInterface.findAll().isEmpty())
			return null;
		else {
			List<Resource> resources = resourceInterface.findAll();
			if (resources != null)
				for (int i = 0; i < resources.size(); i++) {
					if (user.getUserid().equals((resources.get(i).getCreatedBy().getTeacherid()))
							&& resources.get(i).isActive() == true) {
					} else
						resources.remove(i);
				}
			return resources;
		}
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

	public Resource addResource(Resource resource, User user) {
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

	public Resource getResource(String resourceid) {
		if (resourceInterface.findById(resourceid).isPresent()) {
			Resource resource = resourceInterface.findById(resourceid).get();
			return resource;
		} else
			return null;
	}
}