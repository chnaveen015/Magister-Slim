package com.magister.slim.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.magister.slim.references.CourseReference;
import com.magister.slim.references.GroupReference;

@Document
public class Student {

	@Id
	private String id;
	private User userReference;
	private List<GroupReference> groupReference;
	private String name, gender;
	private List<CourseReference> courseReference;
	private long phoneno;
	private boolean active;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUserReference() {
		return userReference;
	}

	public void setUserReference(User userReference) {
		this.userReference = userReference;
	}

	public List<GroupReference> getGroupReference() {
		return groupReference;
	}

	public void setGroupReference(List<GroupReference> groupReference) {
		this.groupReference = groupReference;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<CourseReference> getCourseReference() {
		return courseReference;
	}

	public void setCourseReference(List<CourseReference> courseReference) {
		this.courseReference = courseReference;
	}

	public long getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Student(String id, User userReference, List<GroupReference> groupReference, String name, String gender,
			List<CourseReference> courseReference, long phoneno, boolean active) {
		super();
		this.id = id;
		this.userReference = userReference;
		this.groupReference = groupReference;
		this.name = name;
		this.gender = gender;
		this.courseReference = courseReference;
		this.phoneno = phoneno;
		this.active = active;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", userReference=" + userReference + ", groupReference=" + groupReference
				+ ", name=" + name + ", gender=" + gender + ", courseReference=" + courseReference + ", phoneno="
				+ phoneno + ", active=" + active + "]";
	}

	public Student() {

	}

}
