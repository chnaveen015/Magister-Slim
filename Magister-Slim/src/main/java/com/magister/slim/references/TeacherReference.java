package com.magister.slim.references;

import org.springframework.data.annotation.Id;

public class TeacherReference {
	
	@Id
	private String teacherid;
	private String name;
	private boolean isActive;
	
	public TeacherReference()
	{
		
	}
	
	public TeacherReference(String teacherid, String name, boolean isActive) {
		super();
		this.teacherid = teacherid;
		this.name = name;
		this.isActive = isActive;
	}
	
	public String getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(String teacherid) {
		this.teacherid = teacherid;
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
	
	@Override
	public String toString() {
		return "TeacherReference [teacherid=" + teacherid + ", name=" + name + ", isActive=" + isActive + "]";
	}

}
