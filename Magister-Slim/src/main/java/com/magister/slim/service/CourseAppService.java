<<<<<<< HEAD
package com.magister.slim.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magister.slim.entity.Course;
import com.magister.slim.entity.Group;
import com.magister.slim.entity.OfferingLevel;
import com.magister.slim.entity.StudyGuide;
import com.magister.slim.references.CourseReference;
import com.magister.slim.references.GroupReference;
import com.magister.slim.references.OfferingLevelReference;
import com.magister.slim.references.StudyGuideReference;
import com.magister.slim.repository.CourseInterface;
import com.magister.slim.repository.GroupInterface;
import com.magister.slim.repository.OfferingLevelInterface;

import net.bytebuddy.utility.privilege.GetSystemPropertyAction;

@Service
public class CourseAppService {
	
	@Autowired
	CourseInterface courseInterface;
	@Autowired
	GroupAppService groupAppService;
	@Autowired
	OfferingLevelAppService offeringLevelAppService;
	@Autowired
	OfferingLevelInterface offeringLevelInterface;
	@Autowired
	GroupInterface groupInterface;

	public Course getCourse(String courseid) {
		Course course=courseInterface.findById(courseid).get();
		return course;
	}
	public List<Course> getCourses()
	{
		List<Course> course=courseInterface.findAll();
		return course;
	}
	
	public Course addCourseDetails(Course courseDetails) {
		if(courseInterface.save(courseDetails)!=null)
		{
			if(offeringLevelAppService.updateCourseReferences(courseDetails))
			{
			
					return courseDetails;
			}
			else
				return null;
		}
			
		return null;
	}
	public boolean updateGroupReference(GroupReference groupReference,Course courseDetails)
	{
		List<GroupReference> groupReferences = new ArrayList<GroupReference>();
		if(courseInterface.findById(courseDetails.getCourseId()).isPresent())
		{
		Course course = courseInterface.findById(courseDetails.getCourseId()).get();
		groupReferences = course.getGroupReferences();
		if (groupReferences == null)
			groupReferences = new ArrayList<GroupReference>();
		groupReferences.add(groupReference);
		course.setGroupReferences(groupReferences);
		if(courseInterface.save(course)!=null)
			return true;
		else
			return false;
		}
	return false;
	}
	public Course deleteCourse(String offeringLevelId, String courseId) {
		Course courseDetails=(courseInterface.findAll()).stream().filter(course-> course.getCourseId().equals(courseId)).findFirst().get();
		if(courseDetails!=null)
		{
			courseDetails.setActive(false);
			courseInterface.save(courseDetails);
			offeringLevelAppService.deleteCourseReference(offeringLevelId,courseId);
		   return courseDetails;
		}
		return null;
	}
//	public Course updateCourseDetails(String groupId, Course course) {
//		if (courseInterface.findById(course.getCourseId()).isPresent()) {
//			Course courseDetails = courseInterface.findById(course.getCourseId()).get();
//			courseDetails.setCourseName(course.getCourseName());
//			courseInterface.save(courseDetails);
//			boolean status = groupAppService.updateCourseReferenceDetails(groupId,course);
//			return courseDetails;
//		}
//		return null;
//	}
	public Course updateCourseDetails(String offeringLevelId, Course course) {
		Course courseDetails=(courseInterface.findAll()).stream().filter(SingleCourse-> SingleCourse.getCourseId().equals(course.getCourseId())).findFirst().get();
		if (courseDetails!=null) {
		
			courseDetails.setCourseName(course.getCourseName());
			courseInterface.save(courseDetails);
			offeringLevelAppService.updateCourseReferenceDetails(course);
	//		boolean status = groupAppService.updateCourseReferenceDetails(groupId,course);
			return courseDetails;
		}
		return null;
	}
	public Course getCourseDetailsById(String offeringLevelId, String courseId) {
		if ((courseInterface.findById(courseId).isPresent())) {
			Course courseDetails = courseInterface.findById(courseId).get();
				return courseDetails;

		} else
			return null;

	}
	public Course getCourseByName(int groupId, String courseName) {
		Course courseDetails = courseInterface.getCourseByName(courseName);
		if (courseDetails != null)
			return courseDetails;
		else
			return null;
	}
	public CourseReference getCourseReference(String courseId, String offeringLevelId) {
		// TODO Auto-generated method stub
		Course courseDetails=(courseInterface.findAll()).stream().filter(course-> course.getCourseId().equals(courseId)).findFirst().get();
		if (courseDetails!=null) {
			if (courseDetails.getOfferingLevelReference().getOfferingLevelId().equals(offeringLevelId)
					&& courseDetails.isActive() == true)
				return new CourseReference(courseDetails.getCourseId(), courseDetails.getCourseName(), true);
			else
				return null;
		}
		return null;
	}
	public boolean updateGroupReferences(Group groupDetails) {
		// TODO Auto-generated method stub
		List<GroupReference> groupReferences = new ArrayList<GroupReference>();
		Course courseDetails=(courseInterface.findAll()).stream().filter(course-> course.getCourseId().equals(groupDetails.getCourseReference().getCourseId())).findFirst().get();
		if(courseDetails!=null)
		{
		groupReferences = courseDetails.getGroupReferences();
		if (groupReferences == null)
			groupReferences = new ArrayList<GroupReference>();
		groupReferences.add(new GroupReference(groupDetails.getGroupId(),groupDetails.getGroupName(),true));
		courseDetails.setGroupReferences(groupReferences);
		if(courseInterface.save(courseDetails)!=null)
			return true;
		else
			return false;
		}
		return false;
		
	}
	public boolean updateGroupReferenceDetails(String courseId, Group group) {
		// TODO Auto-generated method stub
		Course courseDetails=(courseInterface.findAll()).stream().filter(course-> course.getCourseId().equals(courseId)).findFirst().get();
		if(courseDetails!=null)
		{
		List<GroupReference> groupReferences = (courseDetails.getGroupReferences()).stream().map(groupReference -> {
			if (groupReference.getGroupId().equals(group.getGroupId())) {
				groupReference.setGroupName(group.getGroupName());
			}
			return groupReference;
		}).collect(Collectors.toList());
		courseDetails.setGroupReferences(groupReferences);
		if(courseInterface.save(courseDetails)!=null)
		return true;
		else
			return false;
		}
		return false;
		
	}
	public boolean deleteGroupReference(String courseId, String groupId) {
		Course courseDetails=(courseInterface.findAll()).stream().filter(course-> course.getCourseId().equals(courseId)).findFirst().get();
		List<GroupReference> groupReferences = courseDetails.getGroupReferences().stream().map(groupReference -> {
			if (groupReference.getGroupId().equals( groupId)) {
				groupReference.setActive(false);
			}
			return groupReference;
		}).collect(Collectors.toList());
		courseDetails.setGroupReferences(groupReferences);
		courseInterface.save(courseDetails);
		return true;
		
	}
	public boolean deleteOfferingLevelreference(String offeringLevelId) {
		OfferingLevel offeringLevel=(offeringLevelInterface.findAll()).stream().filter(offeringLevelDetails-> offeringLevelDetails.getOfferingLevelId().equals(offeringLevelId)).findFirst().get();
		
//		OfferingLevel offeringLevel = offeringLevelInterface.findById(offeringLevelId).get();
		if(offeringLevel.getCourseReferences()!=null)
		{
		List<CourseReference> courseReferences = (offeringLevel.getCourseReferences()).stream().map(courseReference -> {
			courseReference.setActive(false);
			Course course=(courseInterface.findAll()).stream().filter(singleCourse-> singleCourse.getCourseId().equals(courseReference.getCourseId())).findFirst().get();
			course.setActive(false);
			course.getOfferingLevelReference().setActive(false);
			course=deleteGroupReferences(course);
			courseInterface.save(course);
			return courseReference;
		}).collect(Collectors.toList());
		offeringLevel.setCourseReferences(courseReferences);
		offeringLevelInterface.save(offeringLevel);
		return true;
		}
		else return true;
	}
	public Course deleteGroupReferences(Course course)
	{	
		if(course.getGroupReferences()!=null)
		{
		List<GroupReference> groupReferences = (course.getGroupReferences()).stream().map(groupReference -> {
			
			groupReference.setActive(false);
			Group group=groupInterface.findAll().stream().filter(oneGroup->oneGroup.getGroupId().equals(groupReference.getGroupId())).findFirst().get();
			group.setActive(false);
			groupInterface.save(group);
			return groupReference;
		}).collect(Collectors.toList());
		course.setGroupReferences(groupReferences);
		return course;
		}
		return course;
	}
	public boolean updateStudyguideReferences(StudyGuide studyGuide) {
		// TODO Auto-generated method stub
		List<StudyGuideReference> studyGuideReferences = new ArrayList<StudyGuideReference>();
		if(courseInterface.findById(studyGuide.getCourseReference().getCourseId()).isPresent())
		{
		Course courseDetails=courseInterface.findById(studyGuide.getCourseReference().getCourseId()).get();
		studyGuideReferences = courseDetails.getStudyGuideReferences();
		if (studyGuideReferences == null)
			studyGuideReferences = new ArrayList<StudyGuideReference>();
		studyGuideReferences.add(new StudyGuideReference(studyGuide.getStudyGuideId(),studyGuide.getStudyGuideName(),true));
		courseDetails.setStudyGuideReferences(studyGuideReferences);
		if(courseInterface.save(courseDetails)!=null)
			return true;
		else
			return false;
		}
		return false;
	}
	public boolean deleteStudyGuideReference(StudyGuide studyGuide) {
		// TODO Auto-generated method stub
		if(courseInterface.findById(studyGuide.getCourseReference().getCourseId()).isPresent())
		{
		Course courseDetails=courseInterface.findById(studyGuide.getCourseReference().getCourseId()).get();
		List<StudyGuideReference> studyGuideReferences = courseDetails.getStudyGuideReferences().stream().map(stuyguideReference -> {
			if (stuyguideReference.getStudyGuideId().equals( studyGuide.getStudyGuideId())) {
				stuyguideReference.setActive(false);
			}
			return stuyguideReference;
		}).collect(Collectors.toList());
		courseDetails.setStudyGuideReferences(studyGuideReferences);
		if(courseInterface.save(courseDetails)!=null)
		return true;
		else return false;
		}
		return false;
		
	}
	}


=======
package com.magister.slim.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magister.slim.entity.Course;
import com.magister.slim.entity.Group;
import com.magister.slim.entity.OfferingLevel;
import com.magister.slim.entity.StudyGuide;
import com.magister.slim.references.CourseReference;
import com.magister.slim.references.GroupReference;
import com.magister.slim.references.StudyGuideReference;
import com.magister.slim.repository.CourseInterface;
import com.magister.slim.repository.GroupInterface;
import com.magister.slim.repository.OfferingLevelInterface;

@Service
public class CourseAppService {
	
	@Autowired
	CourseInterface courseInterface;
	@Autowired
	GroupAppService groupAppService;
	@Autowired
	OfferingLevelAppService offeringLevelAppService;
	@Autowired
	OfferingLevelInterface offeringLevelInterface;
	@Autowired
	GroupInterface groupInterface;

	public Course getCourse(String courseid) {
		Course course=courseInterface.findById(courseid).get();
		return course;
	}
	public List<Course> getCourses()
	{
		List<Course> course=courseInterface.findAll();
		return course;
	}
	
	public Course addCourseDetails(Course courseDetails) {
		if(courseInterface.save(courseDetails)!=null)
		{
			if(offeringLevelAppService.updateCourseReferences(courseDetails))
			{
			
					return courseDetails;
			}
			else
				return null;
		}
			
		return null;
	}
	public boolean updateGroupReference(GroupReference groupReference,Course courseDetails)
	{
		List<GroupReference> groupReferences = new ArrayList<GroupReference>();
		if(courseInterface.findById(courseDetails.getCourseId()).isPresent())
		{
		Course course = courseInterface.findById(courseDetails.getCourseId()).get();
		groupReferences = course.getGroupReferences();
		if (groupReferences == null)
			groupReferences = new ArrayList<GroupReference>();
		groupReferences.add(groupReference);
		course.setGroupReferences(groupReferences);
		if(courseInterface.save(course)!=null)
			return true;
		else
			return false;
		}
	return false;
	}
	public Course deleteCourse(String offeringLevelId, String courseId) {
		Course courseDetails=(courseInterface.findAll()).stream().filter(course-> course.getCourseId().equals(courseId)).findFirst().get();
		if(courseDetails!=null)
		{
			courseDetails.setActive(false);
			courseInterface.save(courseDetails);
			offeringLevelAppService.deleteCourseReference(offeringLevelId,courseId);
		   return courseDetails;
		}
		return null;
	}
//	public Course updateCourseDetails(String groupId, Course course) {
//		if (courseInterface.findById(course.getCourseId()).isPresent()) {
//			Course courseDetails = courseInterface.findById(course.getCourseId()).get();
//			courseDetails.setCourseName(course.getCourseName());
//			courseInterface.save(courseDetails);
//			boolean status = groupAppService.updateCourseReferenceDetails(groupId,course);
//			return courseDetails;
//		}
//		return null;
//	}
	public Course updateCourseDetails(String offeringLevelId, Course course) {
		Course courseDetails=(courseInterface.findAll()).stream().filter(SingleCourse-> SingleCourse.getCourseId().equals(course.getCourseId())).findFirst().get();
		if (courseDetails!=null) {
		
			courseDetails.setCourseName(course.getCourseName());
			courseInterface.save(courseDetails);
			offeringLevelAppService.updateCourseReferenceDetails(course);
	//		boolean status = groupAppService.updateCourseReferenceDetails(groupId,course);
			return courseDetails;
		}
		return null;
	}
	public Course getCourseDetailsById(String offeringLevelId, String courseId) {
		if ((courseInterface.findById(courseId).isPresent())) {
			Course courseDetails = courseInterface.findById(courseId).get();
				return courseDetails;

		} else
			return null;

	}
	public Course getCourseByName(int groupId, String courseName) {
		Course courseDetails = courseInterface.getCourseByName(courseName);
		if (courseDetails != null)
			return courseDetails;
		else
			return null;
	}
	public CourseReference getCourseReference(String courseId, String offeringLevelId) {
		// TODO Auto-generated method stub
		Course courseDetails=(courseInterface.findAll()).stream().filter(course-> course.getCourseId().equals(courseId)).findFirst().get();
		if (courseDetails!=null) {
			if (courseDetails.getOfferingLevelReference().getOfferingLevelId().equals(offeringLevelId)
					&& courseDetails.isActive() == true)
				return new CourseReference(courseDetails.getCourseId(), courseDetails.getCourseName(), true);
			else
				return null;
		}
		return null;
	}
	public boolean updateGroupReferences(Group groupDetails) {
		// TODO Auto-generated method stub
		List<GroupReference> groupReferences = new ArrayList<GroupReference>();
		Course courseDetails=(courseInterface.findAll()).stream().filter(course-> course.getCourseId().equals(groupDetails.getCourseReference().getCourseId())).findFirst().get();
		if(courseDetails!=null)
		{
		groupReferences = courseDetails.getGroupReferences();
		if (groupReferences == null)
			groupReferences = new ArrayList<GroupReference>();
		groupReferences.add(new GroupReference(groupDetails.getGroupId(),groupDetails.getGroupName(),true));
		courseDetails.setGroupReferences(groupReferences);
		if(courseInterface.save(courseDetails)!=null)
			return true;
		else
			return false;
		}
		return false;
		
	}
	public boolean updateGroupReferenceDetails(String courseId, Group group) {
		// TODO Auto-generated method stub
		Course courseDetails=(courseInterface.findAll()).stream().filter(course-> course.getCourseId().equals(courseId)).findFirst().get();
		if(courseDetails!=null)
		{
		List<GroupReference> groupReferences = (courseDetails.getGroupReferences()).stream().map(groupReference -> {
			if (groupReference.getGroupId().equals(group.getGroupId())) {
				groupReference.setGroupName(group.getGroupName());
			}
			return groupReference;
		}).collect(Collectors.toList());
		courseDetails.setGroupReferences(groupReferences);
		if(courseInterface.save(courseDetails)!=null)
		return true;
		else
			return false;
		}
		return false;
		
	}
	public boolean deleteGroupReference(String courseId, String groupId) {
		Course courseDetails=(courseInterface.findAll()).stream().filter(course-> course.getCourseId().equals(courseId)).findFirst().get();
		List<GroupReference> groupReferences = courseDetails.getGroupReferences().stream().map(groupReference -> {
			if (groupReference.getGroupId().equals( groupId)) {
				groupReference.setActive(false);
			}
			return groupReference;
		}).collect(Collectors.toList());
		courseDetails.setGroupReferences(groupReferences);
		courseInterface.save(courseDetails);
		return true;
		
	}
	public boolean deleteOfferingLevelreference(String offeringLevelId) {
		OfferingLevel offeringLevel=(offeringLevelInterface.findAll()).stream().filter(offeringLevelDetails-> offeringLevelDetails.getOfferingLevelId().equals(offeringLevelId)).findFirst().get();
		
//		OfferingLevel offeringLevel = offeringLevelInterface.findById(offeringLevelId).get();
		if(offeringLevel.getCourseReferences()!=null)
		{
		List<CourseReference> courseReferences = (offeringLevel.getCourseReferences()).stream().map(courseReference -> {
			courseReference.setActive(false);
			Course course=(courseInterface.findAll()).stream().filter(singleCourse-> singleCourse.getCourseId().equals(courseReference.getCourseId())).findFirst().get();
			course.setActive(false);
			course.getOfferingLevelReference().setActive(false);
			course=deleteGroupReferences(course);
			courseInterface.save(course);
			return courseReference;
		}).collect(Collectors.toList());
		offeringLevel.setCourseReferences(courseReferences);
		offeringLevelInterface.save(offeringLevel);
		return true;
		}
		else return true;
	}
	public Course deleteGroupReferences(Course course)
	{	
		if(course.getGroupReferences()!=null)
		{
		List<GroupReference> groupReferences = (course.getGroupReferences()).stream().map(groupReference -> {
			
			groupReference.setActive(false);
			Group group=groupInterface.findAll().stream().filter(oneGroup->oneGroup.getGroupId().equals(groupReference.getGroupId())).findFirst().get();
			group.setActive(false);
			groupInterface.save(group);
			return groupReference;
		}).collect(Collectors.toList());
		course.setGroupReferences(groupReferences);
		return course;
		}
		return course;
	}
	public boolean updateStudyguideReferences(StudyGuide studyGuide) {
		// TODO Auto-generated method stub
		List<StudyGuideReference> studyGuideReferences = new ArrayList<StudyGuideReference>();
		if(courseInterface.findById(studyGuide.getCourseReference().getCourseId()).isPresent())
		{
		Course courseDetails=courseInterface.findById(studyGuide.getCourseReference().getCourseId()).get();
		studyGuideReferences = courseDetails.getStudyGuideReferences();
		if (studyGuideReferences == null)
			studyGuideReferences = new ArrayList<StudyGuideReference>();
		studyGuideReferences.add(new StudyGuideReference(studyGuide.getStudyGuideId(),studyGuide.getStudyGuideName(),true));
		courseDetails.setStudyGuideReferences(studyGuideReferences);
		if(courseInterface.save(courseDetails)!=null)
			return true;
		else
			return false;
		}
		return false;
	}
	public boolean deleteStudyGuideReference(StudyGuide studyGuide) {
		// TODO Auto-generated method stub
		if(courseInterface.findById(studyGuide.getCourseReference().getCourseId()).isPresent())
		{
		Course courseDetails=courseInterface.findById(studyGuide.getCourseReference().getCourseId()).get();
		List<StudyGuideReference> studyGuideReferences = courseDetails.getStudyGuideReferences().stream().map(stuyguideReference -> {
			if (stuyguideReference.getStudyGuideId().equals( studyGuide.getStudyGuideId())) {
				stuyguideReference.setActive(false);
			}
			return stuyguideReference;
		}).collect(Collectors.toList());
		courseDetails.setStudyGuideReferences(studyGuideReferences);
		if(courseInterface.save(courseDetails)!=null)
		return true;
		else return false;
		}
		return false;
		
	}
	}


>>>>>>> Removed Cross Origins
