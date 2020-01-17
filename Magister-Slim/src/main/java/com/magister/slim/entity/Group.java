package com.magister.slim.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.magister.slim.references.CourseReference;
import com.magister.slim.references.StudentReference;
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

	public Group() {

	}

	public Group( String groupName, List<StudentReference> students, TeacherReference teacherReference,
			CourseReference courseReference, boolean isActive) {
		super();
		this.groupName = groupName;
		this.students = students;
		this.teacherReference = teacherReference;
		this.courseReference = courseReference;
		this.isActive = isActive;
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

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseReference == null) ? 0 : courseReference.hashCode());
		result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
		result = prime * result + ((groupName == null) ? 0 : groupName.hashCode());
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + ((students == null) ? 0 : students.hashCode());
		result = prime * result + ((teacherReference == null) ? 0 : teacherReference.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		if (courseReference == null) {
			if (other.courseReference != null)
				return false;
		} else if (!courseReference.equals(other.courseReference))
			return false;
		if (groupId == null) {
			if (other.groupId != null)
				return false;
		} else if (!groupId.equals(other.groupId))
			return false;
		if (groupName == null) {
			if (other.groupName != null)
				return false;
		} else if (!groupName.equals(other.groupName))
			return false;
		if (isActive != other.isActive)
			return false;
		if (students == null) {
			if (other.students != null)
				return false;
		} else if (!students.equals(other.students))
			return false;
		if (teacherReference == null) {
			if (other.teacherReference != null)
				return false;
		} else if (!teacherReference.equals(other.teacherReference))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Group [groupId=" + groupId + ", groupName=" + groupName + ", students=" + students
				+ ", teacherReference=" + teacherReference + ", courseReference=" + courseReference + ", isActive="
				+ isActive + "]";
	}

}
