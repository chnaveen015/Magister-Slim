package com.magister.slim.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.magister.slim.entity.Course;
import com.magister.slim.entity.Group;
import com.magister.slim.entity.Teacher;
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

	public Group addGroupDetails(Group groupDetails) {
		if (groupInterface.save(groupDetails) != null) {
			//offeringLevelAppService.updateGroupReferences(groupDetails);
			teacherAppService.updateGroupReferences(groupDetails);
			courseAppService.updateGroupReferences(groupDetails);
			return groupDetails;
		} else
			return null;
	}

	public Group deleteGroup(String offeringLevelId, String courseId, String groupId) {
		Group group=groupInterface.findAll().stream().filter(oneGroup->oneGroup.getGroupId().equals(groupId)).findFirst().get();
		if (group!=null) {
			if (group.getCourseReference().getCourseId().equals(courseId)) {
				group.setActive(false);
				groupInterface.save(group);
				//offeringLevelAppService.deleteGroupReference(offeringLevelId, groupId);
				courseAppService.deleteGroupReference(courseId,groupId);
			}
			return group;
		}
		return null;
	}

	public Group updateGroupDetails(String courseId, Group groupDetails) {
		Group group=groupInterface.findAll().stream().filter(oneGroup->oneGroup.getGroupId().equals(groupDetails.getGroupId())).findFirst().get();
		if (group!=null) {
			group.setGroupName(groupDetails.getGroupName());
			groupInterface.save(group);
			courseAppService.updateGroupReferenceDetails(courseId,groupDetails);
			return groupDetails;
		}
		return null;
	}

//	public GroupReference getGroupReference(String groupId, String offeringLevelId) {
//		if (groupInterface.findById(groupId).isPresent()) {
//			Group groupDetails = groupInterface.findById(groupId).get();
//			if (groupDetails.getOfferingLevelReference().getOfferingLevelId().equals(offeringLevelId)
//					&& groupDetails.isActive() == true)
//				return new GroupReference(groupDetails.getGroupId(), groupDetails.getGroupName(), true);
//			else
//				return null;
//		}
//		return null;
//	}

//	public boolean updateCourseReferences(GroupReference groupReference, Course courseDetails) {
//		List<CourseReference> courseReferences = new ArrayList<CourseReference>();
//		if (groupInterface.findById(groupReference.getGroupId()).isPresent()) {
//			Group groupDetails = groupInterface.findById(groupReference.getGroupId()).get();
//			courseReferences = groupDetails.getCourseReference();
//			if (courseReferences == null)
//				courseReferences = new ArrayList<CourseReference>();
//			courseReferences.add(new CourseReference(courseDetails.getCourseId(), courseDetails.getCourseName(), true));
//			groupDetails.setCoursesreference(courseReferences);
//			if (groupInterface.save(groupDetails) != null)
//				return true;
//			else
//				return false;
//		}
//		return false;
//	}

//	public boolean deleteCourseReference(String groupId, String courseId) {
//		Group groupDetails = groupInterface.findById(groupId).get();
//		List<CourseReference> courseReferences = (groupDetails.getCoursesreference()).stream().map(courseReference -> {
//			if (courseReference.getCourseId().equals( courseId)) {
//				courseReference.setActive(false);
//			}
//			return courseReference;
//		}).collect(Collectors.toList());
//		groupDetails.setCoursesreference(courseReferences);
//		if(groupInterface.save(groupDetails)!=null)
//		return true;
//		else
//			return false;
//	}

//	public boolean updateCourseReferenceDetails(String groupId, Course course) {
//		Group groupDetails = groupInterface.findById(groupId).get();
//		List<CourseReference> courseReferences = (groupDetails.getCoursesreference()).stream().map(courseReference -> {
//			if (courseReference.getCourseId().equals(course.getCourseId())) {
//				courseReference.setCourseName(course.getCourseName());
//			}
//			return courseReference;
//		}).collect(Collectors.toList());
//		groupDetails.setCoursesreference(courseReferences);
//		if(groupInterface.save(groupDetails)!=null)
//		return true;
//		else
//			return false;
//	}

	public Group getGroupDetailsById(String courseId, String groupId) {
		Group groupDetails=groupInterface.findAll().stream().filter(oneGroup->oneGroup.getGroupId().equals(groupId)).findFirst().get();
		if ((groupDetails!=null)){
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

//	public boolean deleteOfferingLevelreference(String offeringLevelId) {
//		OfferingLevel offeringLevel = offeringLevelInterface.findById(offeringLevelId).get();
//		List<GroupReference> groupReferences = (offeringLevel.getGroupReferences()).stream().map(groupReference -> {
//			groupReference.setActive(false);
//			Group group=groupInterface.findById(groupReference.getGroupId()).get();
//			group.setActive(false);
//			group.getOfferingLevelReference().setActive(false);
//			group=deleteCourseReferences(group);
//			groupInterface.save(group);
//			return groupReference;
//		}).collect(Collectors.toList());
//		offeringLevel.setGroupReferences(groupReferences);
//		offeringLevelInterface.save(offeringLevel);
//		return true;
//	}
//	public Group deleteCourseReferences(Group group)
//	{
//		List<CourseReference> courseReferences = (group.getCoursesreference()).stream().map(courseReference -> {
//			
//			courseReference.setActive(false);
//			Course course=courseInterface.findById(courseReference.getCourseId()).get();
//			course.setActive(false);
//			course=deleteGroupReferences(course,group);
//			courseInterface.save(course);
//			return courseReference;
//		}).collect(Collectors.toList());
//		group.setCoursesreference(courseReferences);
//		return group;
//		
//	}

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
		if(teacherInterface.findById(teacherDetails.getTeacherId()).isPresent())
		{
		Teacher teacher = teacherInterface.findById(teacherDetails.getTeacherId()).get();
		List<GroupReference> groupReferences = (teacher.getGroupReference()).stream().map(groupReference -> {
			groupReference.setActive(false);
			Group group=groupInterface.findById(groupReference.getGroupId()).get();
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
		if(teacherInterface.findById(teacherDetails.getTeacherId()).isPresent())
		{
		Teacher teacher = teacherInterface.findById(teacherDetails.getTeacherId()).get();
		List<GroupReference> groupReferences = (teacher.getGroupReference()).stream().map(groupReference -> {
			Group group=groupInterface.findById(groupReference.getGroupId()).get();
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
}
