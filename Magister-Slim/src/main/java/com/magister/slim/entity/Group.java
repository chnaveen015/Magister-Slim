package com.magister.slim.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.magister.slim.references.CourseReference;
import com.magister.slim.references.OfferingLevelReference;
import com.magister.slim.references.StudentReference;
import com.magister.slim.references.StudyGuideReference;
import com.magister.slim.references.TeacherReference;

@Document
public class Group {

	@Id
	private String groupId;
	private String groupName;
	private List<StudentReference> students;
	private TeacherReference teacherReference;
	private CourseReference courseReference;
	private boolean isActive;

	public Group()
	{
		
	}


	public String getGroupId() {
		return groupId;
	}


	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}


	public String getGroupName() {
		return groupName;
	}


	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}


	public List<StudentReference> getStudents() {
		return students;
	}


	public void setStudents(List<StudentReference> students) {
		this.students = students;
	}


	public TeacherReference getTeacherReference() {
		return teacherReference;
	}


	public void setTeacherReference(TeacherReference teacherReference) {
		this.teacherReference = teacherReference;
	}




	public boolean isActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	public CourseReference getCourseReference() {
		return courseReference;
	}


	public void setCourseReference(CourseReference courseReference) {
		this.courseReference = courseReference;
	}


	public Group(String groupId, String groupName, List<StudentReference> students, TeacherReference teacherReference,
			CourseReference courseReference, boolean isActive) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.students = students;
		this.teacherReference = teacherReference;
		this.courseReference = courseReference;
		this.isActive = isActive;
	}


	@Override
	public String toString() {
		return "Group [groupId=" + groupId + ", groupName=" + groupName + ", students=" + students
				+ ", teacherReference=" + teacherReference + ", courseReference=" + courseReference + ", isActive="
				+ isActive + "]";
	}





	
	
}
