package com.magister.slim.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.magister.slim.references.StudyGuideReference;
import com.magister.slim.references.TeacherReference;

@Document
public class Resource {

	@Id
	private String resourceId;
	private String resourceType;
	private String resourceName;
	private StudyGuideReference studyGuideReference;
	private TeacherReference createdBy;
	private boolean isActive;

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

	public StudyGuideReference getStudyGuideReference() {
		return studyGuideReference;
	}

	public void setStudyGuideReference(StudyGuideReference studyGuideReference) {
		this.studyGuideReference = studyGuideReference;
	}

	public TeacherReference getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(TeacherReference createdBy) {
		this.createdBy = createdBy;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Resource [resourceId=" + resourceId + ", resourceType=" + resourceType + ", resourceName="
				+ resourceName + ", studyGuideReference=" + studyGuideReference + ", createdBy=" + createdBy
				+ ", isActive=" + isActive + "]";
	}

	public Resource(String resourceId, String resourceType, String resourceName, StudyGuideReference studyGuideReference,
			TeacherReference createdBy, boolean isActive) {
		super();
		this.resourceId = resourceId;
		this.resourceType = resourceType;
		this.resourceName = resourceName;
		this.studyGuideReference = studyGuideReference;
		this.createdBy = createdBy;
		this.isActive = isActive;
	}
	public Resource()
	{
		
	}
}
