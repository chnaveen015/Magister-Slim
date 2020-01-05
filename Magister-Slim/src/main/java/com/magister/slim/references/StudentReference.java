package com.magister.slim.references;

import org.springframework.data.annotation.Id;

public class StudentReference {

	@Id
	private String id;
	private String name;
	private boolean isActive;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public StudentReference(String id, String name, boolean isActive) {
		super();
		this.id = id;
		this.name = name;
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "StudentReference [id=" + id + ", name=" + name + ", isActive=" + isActive + "]";
	}
	public StudentReference()
	{
		
	}
}
