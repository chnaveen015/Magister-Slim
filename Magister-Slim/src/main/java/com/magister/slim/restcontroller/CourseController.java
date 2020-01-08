package com.magister.slim.restcontroller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.magister.slim.entity.Course;
import com.magister.slim.references.OfferingLevelReference;
import com.magister.slim.service.CourseAppService;
import com.magister.slim.service.GroupAppService;
import com.magister.slim.service.OfferingLevelAppService;
import com.magister.slim.service.UserAppService;

@RestController
@RequestMapping("offering/{offeringId}/offering-level/{offeringLevelId}/course")
public class CourseController {

	@Autowired
	CourseAppService courseAppService;
	@Autowired
	GroupAppService groupAppService;
	@Autowired
	OfferingLevelAppService offeringLevelAppService;
	@Autowired
	UserAppService userAppService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public Course addCourse(@PathVariable("offeringId") String offeringId,@PathVariable("offeringLevelId") String offeringLevelId,@RequestBody Course courseDetails) throws ParseException {
		courseDetails.setActive(true);
		courseDetails.setCourseId(UserAppService.generateNumber());
		OfferingLevelReference offeringLevelReference=offeringLevelAppService.getOfferingLevelReference(offeringId,offeringLevelId);
		if(offeringLevelReference!=null)
		{
			courseDetails.setOfferingLevelReference(offeringLevelReference);
			Course status=courseAppService.addCourseDetails(courseDetails);
		return status;
		}
		return null;
	}


	@RequestMapping(value = "/{courseId}", method = RequestMethod.DELETE)
	public Course removeCourse(@PathVariable("offeringId")String offeringId,@PathVariable("offeringLevelId") String offeringLevelId,@PathVariable("courseId")String courseId) {
		Course status=courseAppService.deleteCourse(offeringLevelId,courseId);
		return status;
	}
	

	@RequestMapping(value = "{courseId}", method = RequestMethod.PUT)
	public Course updateCourseDetails(@PathVariable("offeringId") String offeringId,@PathVariable("offeringLevelId") String offeringLevelId,@PathVariable("courseId")String courseId,@RequestBody Course course) {
		course.setCourseId(courseId);
		course.setOfferingLevelReference(new OfferingLevelReference());
		course.getOfferingLevelReference().setOfferingLevelId(offeringLevelId);
		Course status=courseAppService.updateCourseDetails(offeringLevelId,course);
		return status;
	}
	
	@RequestMapping(value = "{courseId}", method = RequestMethod.GET)
	public Course getCourseDetails(@PathVariable("offeringId") String offeringId,@PathVariable("offeringLevelId") String offeringLevelId,@PathVariable("courseId")String courseId) {
		Course coureDetails=courseAppService.getCourseDetailsById(offeringLevelId,courseId);
		return coureDetails;

	}

	@GetMapping()
	public List<Course> getAllCourses()
	{
	return courseAppService.getCourses();
	}
}
