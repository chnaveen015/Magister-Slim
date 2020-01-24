package com.magister.slim.restcontroller;

import java.text.ParseException; 
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.magister.slim.entity.Group;
import com.magister.slim.entity.User;
import com.magister.slim.references.CourseReference;
import com.magister.slim.service.CourseAppService;
import com.magister.slim.service.GroupAppService;
import com.magister.slim.service.OfferingLevelAppService;
import com.magister.slim.service.StudyGuideAppService;
import com.magister.slim.service.UserAppService;

@RestController
public class GroupController {

	@Autowired
	GroupAppService groupAppService;
	@Autowired
	OfferingLevelAppService offeringLevelAppService;
	@Autowired
	CourseAppService courseAppService;
	@Autowired
	UserAppService userAppService;
	@Autowired
	StudyGuideAppService studyGuideAppService;

	@PostMapping(value="offering/{offeringId}/offering-level/{offeringLevelId}/course/{courseId}/group")
	public Group createGroup(@PathVariable("offeringId") String offeringId,
			@PathVariable("offeringLevelId") String offeringLevelId, @PathVariable("courseId") String courseId,
			@RequestBody Group groupDetails, HttpServletRequest request) throws ParseException {
		groupDetails.setActive(true);
		groupDetails.setGroupId(UserAppService.generateNumber());
		User user = (User) request.getServletContext().getAttribute("user");
		groupDetails.setTeacherReference(studyGuideAppService.teacherDetails(user.getUserid(), user.getUsername()));
		CourseReference courseReference = courseAppService.getCourseReference(courseId, offeringLevelId);
		if (courseReference != null) {
			groupDetails.setCourseReference(courseReference);
			Group status = groupAppService.addGroupDetails(groupDetails,user);
			return status;
		} else
			return null;
	}

	@RequestMapping(value = "offering/{offeringId}/offering-level/{offeringLevelId}/course/{courseId}/group/{groupId}", method = RequestMethod.PUT)
	public Group updateGroupDetails(@PathVariable("offeringId") String offeringId,
			@PathVariable("offeringLevelId") String offeringLevelId, @PathVariable("courseId") String courseId,
			@PathVariable("groupId") String groupId, @RequestBody Group groupDetails) {
		groupDetails.setGroupId(groupId);
		Group status = groupAppService.updateGroupDetails(courseId, groupDetails);
		return status;
	}

	@RequestMapping(value = "offering/{offeringId}/offering-level/{offeringLevelId}/course/{courseId}/group/{groupId}", method = RequestMethod.DELETE)
	public Group deleteGroupDeatils(@PathVariable("offeringId") String offeringId,
			@PathVariable("offeringLevelId") String offeringLevelId, @PathVariable("courseId") String courseId,
			@PathVariable("groupId") String groupId) {
		Group status = groupAppService.deleteGroup(offeringLevelId, courseId, groupId);
		return status;
	}

	@RequestMapping(value = "offering/{offeringId}/offering-level/{offeringLevelId}/course/{courseId}/group/{groupId}", method = RequestMethod.GET)
	public Group getGroupDetails(@PathVariable("offeringId") String offeringId,
			@PathVariable("offeringLevelId") String offeringLevelId, @PathVariable("courseId") String courseId,
			@PathVariable("groupId") String groupId) {
		Group groupDetails = groupAppService.getGroupDetailsById(courseId, groupId);

		return groupDetails;

	}

//	@GetMapping()
//	public List<Group> getGroupDetailsByName(@RequestParam("offeringId") String offeringId,
//			@RequestParam("offeringLevelId") String offeringLevelId, @RequestParam("courseId") String courseId,
//			@RequestParam("groupName") String groupName) {
//		return groupAppService.getGroupByName(courseId, groupName);
//
//	}
	@RequestMapping(value="groups/get-groups",method=RequestMethod.GET)
	public List<Group> getGroups()
	{
		return groupAppService.getAllGroups();
	}
}
