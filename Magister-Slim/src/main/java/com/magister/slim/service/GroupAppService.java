package com.magister.slim.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.magister.slim.entity.Course;
import com.magister.slim.entity.Group;
import com.magister.slim.entity.Teacher;
import com.magister.slim.entity.User;
import com.magister.slim.references.GroupReference;
import com.magister.slim.references.StudentReference;
import com.magister.slim.references.StudyGuideReference;
import com.magister.slim.repository.CourseInterface;
import com.magister.slim.repository.GroupInterface;
import com.magister.slim.repository.OfferingLevelInterface;
import com.magister.slim.repository.TeacherInterface;

@Service
public class GroupAppService {

	@Autowired
	GroupInterface groupInterface;
	@Autowired
	CourseAppService courseAppService;
	@Autowired
	TeacherAppService teacherAppService;
	@Autowired
	StudentAppService studentAppService;
	@Autowired
	OfferingLevelAppService offeringLevelAppService;
	@Autowired
	OfferingLevelInterface offeringLevelInterface;
	@Autowired
	CourseInterface courseInterface;
	@Autowired
	TeacherInterface teacherInterface;

	public StudyGuideReference studyGuideDetails(String id, String studyGuideName) {
		StudyGuideReference studyGuideReference = new StudyGuideReference();
		studyGuideReference.setStudyGuideId(id);
		studyGuideReference.setStudyGuideName(studyGuideName);
		return studyGuideReference;
	}

	public List<StudentReference> studentDetails(String id, String studentName) {
		StudentReference student = new StudentReference();
		List<StudentReference> studentReference = new ArrayList<StudentReference>();
		student.setId(id);
		student.setName(studentName);
		studentReference.add(student);
		return studentReference;
	}

	public Group deleteGroup(Group group) {
		groupInterface.deleteById(group.getGroupId());
		return group;
	}

	public Group addGroupDetails(Group groupDetails,User user) {
		if (groupInterface.save(groupDetails) != null) {
			teacherAppService.updateGroupReferences(groupDetails);
			courseAppService.updateGroupReferences(groupDetails);
			return groupDetails;
		} else
			return null;
	}

	public Group deleteGroup(String offeringLevelId, String courseId, String groupId) {
		Group group = groupInterface.findAll().stream().filter(oneGroup -> oneGroup.getGroupId().equals(groupId))
				.findFirst().get();
		if (group != null) {
			if (group.getCourseReference().getCourseId().equals(courseId)) {
				group.setActive(false);
				groupInterface.save(group);
				courseAppService.deleteGroupReference(courseId, groupId);
			}
			return group;
		}
		return null;
	}

	public Group updateGroupDetails(String courseId, Group groupDetails) {
		Group group = groupInterface.findAll().stream()
				.filter(oneGroup -> oneGroup.getGroupId().equals(groupDetails.getGroupId())).findFirst().get();
		if (group != null) {
			group.setGroupName(groupDetails.getGroupName());
			groupInterface.save(group);
			courseAppService.updateGroupReferenceDetails(courseId, groupDetails);
			return groupDetails;
		}
		return null;
	}

	public Group getGroupDetailsById(String courseId, String groupId) {
		Group groupDetails = groupInterface.findAll().stream().filter(oneGroup -> oneGroup.getGroupId().equals(groupId))
				.findFirst().get();
		if ((groupDetails != null)) {
			if (groupDetails.getCourseReference().getCourseId().equals(courseId))
				return groupDetails;
			else
				return null;
		} else
			return null;
	}

	public List<Group> getGroupByName(String courseId, String groupName) {
		List<Group> groupDetails = groupInterface.getGroupByName(groupName);
		if (groupDetails != null)
			return groupDetails;
		else
			return null;
	}

	@SuppressWarnings("unused")
	private Course deleteGroupReferences(Course course, Group group) {

		List<GroupReference> groupReferences = course.getGroupReferences().stream().map(groupReference -> {
			if (groupReference.getGroupId().equals(group.getGroupId())) {
				groupReference.setActive(false);
			}
			return groupReference;
		}).collect(Collectors.toList());
		course.setGroupReferences(groupReferences);
		return course;
	}

	public boolean deleteTeacherReference(Teacher teacherDetails) {
		if (teacherInterface.findById(teacherDetails.getTeacherId()).isPresent()) {
			Teacher teacher = teacherInterface.findById(teacherDetails.getTeacherId()).get();
			List<GroupReference> groupReferences = (teacher.getGroupReference()).stream().map(groupReference -> {
				groupReference.setActive(false);
				Group group = groupInterface.findById(groupReference.getGroupId()).get();
				group.setActive(false);
				group.getTeacherReference().setActive(false);
				groupInterface.save(group);
				return groupReference;
			}).collect(Collectors.toList());
			teacher.setGroupReference(groupReferences);
			teacherInterface.save(teacher);
			return true;
		}
		return false;
	}

	public boolean updateTeacherReferenceDetails(Teacher teacherDetails) {
		if (teacherInterface.findById(teacherDetails.getTeacherId()).isPresent()) {
			Teacher teacher = teacherInterface.findById(teacherDetails.getTeacherId()).get();
			List<GroupReference> groupReferences = (teacher.getGroupReference()).stream().map(groupReference -> {
				Group group = groupInterface.findById(groupReference.getGroupId()).get();
				group.getTeacherReference().setName(teacherDetails.getName());
				groupInterface.save(group);
				return groupReference;
			}).collect(Collectors.toList());
			teacher.setGroupReference(groupReferences);
			teacherInterface.save(teacher);
			return true;
		}
		return false;

	}

	public List<Group> getAllGroups() {
		// TODO Auto-generated method stub
		return groupInterface.findAll();
	}
}
