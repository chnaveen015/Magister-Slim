package com.magister.slim.references;

import org.springframework.data.annotation.Id;

public class ResourceReference {

	@Id
	private String resourceId;
	private String resourceType;
	private String resourceName;
	
	public ResourceReference()
	{
		
	}

	public ResourceReference(String resourceId, String resourceType, String resourceName) {
		super();
		this.resourceId = resourceId;
		this.resourceType = resourceType;
		this.resourceName = resourceName;
	}


	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	
}
