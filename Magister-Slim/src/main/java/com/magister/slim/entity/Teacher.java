package com.magister.slim.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.magister.slim.references.GroupReference;

@Document
public class Teacher {

	@Id
	private String teacherId;
	private User userReference;
	private String name;
	private String address;
	private long phoneno;
	private List<GroupReference> groupReference;
	private int age;
	private gender gender;
	private boolean isActive;

	public Teacher() {

	}

	
	
	public Teacher(User userReference, String name, String address, long phoneno, List<GroupReference> groupReference,
			int age, com.magister.slim.entity.Teacher.gender gender, boolean isActive) {
		super();
		this.userReference = userReference;
		this.name = name;
		this.address = address;
		this.phoneno = phoneno;
		this.groupReference = groupReference;
		this.age = age;
		this.gender = gender;
		this.isActive = isActive;
	}



	public enum gender {
		MALE, FEMALE;
	}
	
	public List<GroupReference> getGroupReference() {
		return groupReference;
	}

	public void setGroupReference(List<GroupReference> groupReference) {
		this.groupReference = groupReference;
	}

	
	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherid) {
		this.teacherId = teacherid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	

	public gender getGender() {
		return gender;
	}



	public void setGender(gender gender) {
		this.gender = gender;
	}



	public boolean isActive() {
		return isActive;
	}



	public void setActive(boolean active) {
		this.isActive = active;
	}

	
	
	
	
	public Teacher(String name, int age, com.magister.slim.entity.Teacher.gender gender, boolean isActive) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.isActive = isActive;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + age;
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((groupReference == null) ? 0 : groupReference.hashCode());
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (phoneno ^ (phoneno >>> 32));
		result = prime * result + ((teacherId == null) ? 0 : teacherId.hashCode());
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
		Teacher other = (Teacher) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (age != other.age)
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
		if (isActive != other.isActive)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phoneno != other.phoneno)
			return false;
		if (teacherId == null) {
			if (other.teacherId != null)
				return false;
		} else if (!teacherId.equals(other.teacherId))
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
		return "Teacher [teacherid=" + teacherId + ", userReference=" + userReference + ", name=" + name + ", address="
				+ address + ", phoneno=" + phoneno + ", groupReference=" + groupReference + ", age=" + age + ", gender="
				+ gender + ", isActive=" + isActive + "]";
	}

	
	public User getUserReference() {
		return userReference;
	}

	public void setUserReference(User userReference) {
		this.userReference = userReference;
	}

}
