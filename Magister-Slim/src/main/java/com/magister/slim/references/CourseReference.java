package com.magister.slim.references;

import org.springframework.data.annotation.Id;

public class CourseReference {

	@Id
	private String courseId;
	private String courseName;
	private boolean isActive;
	

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	
	@Override
	public String toString() {
		return "CourseReference [courseId=" + courseId + ", courseName=" + courseName + ", isActive=" + isActive + "]";
	}

	public CourseReference(String courseId, String courseName, boolean isActive) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.isActive = isActive;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public CourseReference()
	{
		
	}

}
