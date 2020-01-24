package com.magister.slim.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magister.slim.entity.Course;
import com.magister.slim.entity.Offering;
import com.magister.slim.entity.OfferingLevel;
import com.magister.slim.references.CourseReference;
import com.magister.slim.references.OfferingLevelReference;
import com.magister.slim.repository.GroupInterface;
import com.magister.slim.repository.OfferingLevelInterface;

@Service
public class OfferingLevelAppService {

	@Autowired
	OfferingLevelInterface offeringLevelInterface;
	@Autowired
	OfferingAppService offeringAppService;
	@Autowired
	GroupAppService groupAppService;
	@Autowired
	GroupInterface groupInterface;
	@Autowired
	CourseAppService courseAppService;

	public OfferingLevel addOfferingLevel(OfferingLevel offeringLevel) {
		if (offeringAppService.updateOfferingReferences(offeringLevel)) {
			offeringLevelInterface.save(offeringLevel);
			return offeringLevel;
		} else
			return null;
	}

	public OfferingLevel getOfferingLevel(String offeringLevelid) {
		if (offeringLevelInterface.getOfferingLevel(offeringLevelid)!=null) {
			OfferingLevel offeringLevel = offeringLevelInterface.getOfferingLevel(offeringLevelid);
			System.out.println(offeringLevel);
			return offeringLevel;
		} else
			return null;
	}

	public OfferingLevel deleteOfferingLevel(String offeringId, String offeringLevelId) {
		OfferingLevel offeringLevel = offeringLevelInterface.findById(offeringLevelId).get();
		offeringLevel.setActive(false);
		offeringLevelInterface.save(offeringLevel);
		offeringAppService.deleteOfferingLevelReference(offeringId, offeringLevelId);
		courseAppService.deleteOfferingLevelreference(offeringLevelId);
		return offeringLevel;
	}

	public OfferingLevel updateOfferingLevelDetails(OfferingLevel offeringLevel) {
		OfferingLevel offeringLevelDetails = offeringLevelInterface.findById(offeringLevel.getOfferingLevelId()).get();
		offeringLevelDetails.setOfferingLevelName(offeringLevel.getOfferingLevelName());
		offeringLevelInterface.save(offeringLevelDetails);
		offeringAppService.updateOfferingLevelReferenceDetails(offeringLevel);
		return offeringLevel;
	}

	public OfferingLevel getOfferingLevelById(String offeringId, String offeringLevelId) {
		Offering offering = (offeringAppService.getOfferings()).stream()
				.filter(oneOffering -> oneOffering.getOfferingId().equals(offeringId)).findFirst().get();
		if (offering != null) {
			OfferingLevel offeringLevel = (offeringLevelInterface.findAll()).stream()
					.filter(oneOffering -> oneOffering.getOfferingLevelId().equals(offeringLevelId)).findFirst().get();
			if (offeringLevel != null)
				if (offeringLevel.getOfferingReference().getOfferingId().equals(offeringId))
					return offeringLevel;
				else
					return null;
			else
				return null;
		} else
			return null;
	}

	public OfferingLevel getOfferingLevelByName(String offeringId, String offeringLevelName) {
		OfferingLevel offeringLevel = offeringLevelInterface.getOfferingLevelByName(offeringLevelName);
		if (offeringLevel != null && offeringLevel.getOfferingReference().getOfferingId().equals(offeringId))
			return offeringLevel;
		else
			return null;
	}

	public OfferingLevelReference getOfferingLevelReference(String offeringId, String offeringLevelId) {

		if (offeringLevelInterface.findById(offeringLevelId).isPresent()) {
			OfferingLevel offeringLevel = offeringLevelInterface.findById(offeringLevelId).get();
			if (offeringLevel.getOfferingReference().getOfferingId().equals(offeringId)
					&& offeringLevel.isActive() == true)
				return new OfferingLevelReference(offeringLevel.getOfferingLevelId(),
						offeringLevel.getOfferingLevelName(), true);
			else
				return null;
		}
		return null;
	}

	public boolean deleteCourseReference(String offeringLevelId, String courseId) {
		OfferingLevel offeringLevel = offeringLevelInterface.findById(offeringLevelId).get();
		List<CourseReference> courseReferences = offeringLevel.getCourseReferences().stream().map(courseReference -> {
			if (courseReference.getCourseId().equals(courseId)) {
				courseReference.setActive(false);
			}
			return courseReference;
		}).collect(Collectors.toList());
		offeringLevel.setCourseReferences(courseReferences);
		offeringLevelInterface.save(offeringLevel);
		return true;
	}

	public boolean updateCourseReferences(Course courseDetails) {

		List<CourseReference> courseReferences = new ArrayList<CourseReference>();
		OfferingLevel offeringLevel = (offeringLevelInterface.findAll()).stream()
				.filter(offeringLevelDetails -> offeringLevelDetails.getOfferingLevelId()
						.equals(courseDetails.getOfferingLevelReference().getOfferingLevelId()))
				.findFirst().get();
		if (offeringLevel != null) {
			courseReferences = offeringLevel.getCourseReferences();
			if (courseReferences == null)
				courseReferences = new ArrayList<CourseReference>();
			courseReferences.add(new CourseReference(courseDetails.getCourseId(), courseDetails.getCourseName(), true));
			offeringLevel.setCourseReferences(courseReferences);
			offeringLevelInterface.save(offeringLevel);
			return true;
		} else
			return false;
	}

	public boolean updateCourseReferenceDetails(Course courseDetails) {

		OfferingLevel offeringLevel = (offeringLevelInterface.findAll()).stream()
				.filter(offeringLevelDetails -> offeringLevelDetails.getOfferingLevelId()
						.equals(courseDetails.getOfferingLevelReference().getOfferingLevelId()))
				.findFirst().get();
		List<CourseReference> courseReferences = offeringLevel.getCourseReferences().stream().map(courseReference -> {
			if (courseReference.getCourseId().equals(courseDetails.getCourseId())) {
				courseReference.setCourseName(courseDetails.getCourseName());
			}
			return courseReference;
		}).collect(Collectors.toList());
		offeringLevel.setCourseReferences(courseReferences);
		offeringLevelInterface.save(offeringLevel);
		return true;
	}

}
