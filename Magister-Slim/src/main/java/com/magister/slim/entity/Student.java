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
	
	public Student() {

	}

	public Student( User userReference, List<GroupReference> groupReference, String name, String gender,
			List<CourseReference> courseReference, long phoneno, boolean active) {
		super();
		this.userReference = userReference;
		this.groupReference = groupReference;
		this.name = name;
		this.gender = gender;
		this.courseReference = courseReference;
		this.phoneno = phoneno;
		this.active = active;
	}


	public Student(User userReference, String name, String gender, int phoneno, boolean active) {
		this.name = name;
		this.userReference = userReference;
		this.gender = gender;
		this.phoneno = phoneno;
		this.active = active;
	}
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

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + ((courseReference == null) ? 0 : courseReference.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((groupReference == null) ? 0 : groupReference.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (phoneno ^ (phoneno >>> 32));
		result = prime * result + ((userReference == null) ? 0 : userReference.hashCode());
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
		Student other = (Student) obj;
		if (active != other.active)
			return false;
		if (courseReference == null) {
			if (other.courseReference != null)
				return false;
		} else if (!courseReference.equals(other.courseReference))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (groupReference == null) {
			if (other.groupReference != null)
				return false;
		} else if (!groupReference.equals(other.groupReference))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phoneno != other.phoneno)
			return false;
		if (userReference == null) {
			if (other.userReference != null)
				return false;
		} else if (!userReference.equals(other.userReference))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", userReference=" + userReference + ", groupReference=" + groupReference
				+ ", name=" + name + ", gender=" + gender + ", courseReference=" + courseReference + ", phoneno="
				+ phoneno + ", active=" + active + "]";
	}

	
}
