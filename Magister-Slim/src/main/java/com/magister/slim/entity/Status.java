package com.magister.slim.entity;

import org.springframework.data.annotation.Id;

public class Status {
	
	@Id
	private String id;
	enum statusState{
		STARTED,HANDEDIN,GRADED,COMPLETED;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
