package com.magister.slim.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magister.slim.entity.Course;
import com.magister.slim.entity.Offering;
import com.magister.slim.entity.OfferingLevel;
import com.magister.slim.entity.StudyGuide;
import com.magister.slim.entity.Theme;
import com.magister.slim.references.CourseReference;
import com.magister.slim.references.OfferingLevelReference;
import com.magister.slim.references.OfferingReference;
import com.magister.slim.references.ThemeReference;
import com.magister.slim.repository.CourseInterface;
import com.magister.slim.repository.OfferingInterface;
import com.magister.slim.repository.OfferingLevelInterface;

@Service
public class OfferingAppService {

	@Autowired
	OfferingInterface offeringInterface;
	@Autowired
	OfferingLevelInterface offeringLevelInterface;
	@Autowired
	CourseInterface courseInterface;

	public Offering addOfferingDetails(Offering offering) {
		return offeringInterface.save(offering);
	}

	public Offering deleteOffering(String offeringId) {
		Offering offering = offeringInterface.findById(offeringId).get();
		if(offering!=null)
		offering.setActive(false);
		if(offering.getOfferingLevelReferences()!=null)
		{
		List<OfferingLevelReference> offeringLevelReferences = offering.getOfferingLevelReferences().stream().map(offeringLevelReference -> {
			offeringLevelReference.setActive(false);
			OfferingLevel offeringLevel=offeringLevelInterface.findById(offeringLevelReference.getOfferingLevelId()).get();
			offeringLevel.setActive(false);
			offeringLevel.getOfferingReference().setActive(false);
			List<CourseReference> courseReferences=offeringLevel.getCourseReferences();
			if(courseReferences!=null)
			{
				courseReferences=courseReferences.stream().map(courseReference -> {
					courseReference.setActive(false);
					Course course=courseInterface.findById(courseReference.getCourseId()).get();
					if(course!=null)
					{
						course.setActive(false);
						course.getOfferingLevelReference().setActive(false);
					courseInterface.save(course);
					}
					return courseReference;
					}).collect(Collectors.toList());
			}
			offeringLevel.setCourseReferences(courseReferences);
			offeringLevelInterface.save(offeringLevel);
			return offeringLevelReference;
		}).collect(Collectors.toList());
		offering.setOfferingLevelReferences(offeringLevelReferences);
		offeringInterface.save(offering);
		return offering;
		}

		return null;

	}

	public Offering updateOfferingName(Offering offering) {
		Offering offeringDetails = offeringInterface.findById(offering.getOfferingId()).get();
		offeringDetails.setOfferingName(offering.getOfferingName());
		return offeringInterface.save(offeringDetails);
	}

	public List<Offering> getOfferings() {
		List<Offering> offerings = offeringInterface.findAll();
		if (offerings != null) {
			List<Offering> updatedOfferings = offerings.stream().filter(offering -> offering.isActive() == true)
					.collect(Collectors.toList());
			return updatedOfferings;
		} else
			return offerings;
	}

	public Offering getOfferingById(String offeringId) {
		if (offeringInterface.findById(offeringId).isPresent())
			return offeringInterface.findById(offeringId).get();
		else
			return null;
	}

	public boolean updateOfferingReferences(OfferingLevel offeringLevel) {
		List<OfferingLevelReference> offeringLevelReferences = new ArrayList<OfferingLevelReference>();
		if (offeringInterface.findById(offeringLevel.getOfferingReference().getOfferingId()).isPresent()) {
			Offering offering = offeringInterface.findById(offeringLevel.getOfferingReference().getOfferingId()).get();
			offeringLevelReferences = offering.getOfferingLevelReferences();
			if (offeringLevelReferences == null)
				offeringLevelReferences = new ArrayList<OfferingLevelReference>();
			offeringLevelReferences.add(new OfferingLevelReference(offeringLevel.getOfferingLevelId(),
					offeringLevel.getOfferingLevelName(), offeringLevel.isActive()));
			offering.setOfferingLevelReferences(offeringLevelReferences);
			offeringInterface.save(offering);
			return true;
		} else
			return false;
	}

	public boolean deleteOfferingLevelReference(String offeringId, String offeringLevelId) {

		Offering offering = offeringInterface.findById(offeringId).get();
		List<OfferingLevelReference> offeringLevelReferences = offering.getOfferingLevelReferences().stream()
				.map(offeringReference -> {
					if (offeringReference.getOfferingLevelId().equals(offeringLevelId)) {
						offeringReference.setActive(false);
					}
					return offeringReference;
				}).collect(Collectors.toList());
		offering.setOfferingLevelReferences(offeringLevelReferences);
		offeringInterface.save(offering);
		return true;

	}

	public boolean updateOfferingLevelReferenceDetails(OfferingLevel offeringLevel) {
		Offering offering = offeringInterface.findById(offeringLevel.getOfferingReference().getOfferingId()).get();
		List<OfferingLevelReference> offeringLevelReferences = offering.getOfferingLevelReferences().stream()
				.map(offeringReference -> {
					if (offeringReference.getOfferingLevelId().equals(offeringLevel.getOfferingLevelId())) {
						offeringReference.setOfferingLevelName(offeringLevel.getOfferingLevelName());
					}
					return offeringReference;
				}).collect(Collectors.toList());
		offering.setOfferingLevelReferences(offeringLevelReferences);
		offeringInterface.save(offering);
		return true;
	}


}
