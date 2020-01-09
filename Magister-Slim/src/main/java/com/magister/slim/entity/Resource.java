package com.magister.slim.entity;

import java.util.List;

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
	private List<StudyGuideReference> studyGuideReferences;
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

	public List<StudyGuideReference> getStudyGuideReference() {
		return studyGuideReferences;
	}

	public void setStudyGuideReference(List<StudyGuideReference> studyGuideReference) {
		this.studyGuideReferences = studyGuideReference;
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
				+ resourceName + ", studyGuideReferences=" + studyGuideReferences + ", createdBy=" + createdBy
				+ ", isActive=" + isActive + "]";
	}

	public Resource(String resourceId, String resourceType, String resourceName,
			List<StudyGuideReference> studyGuideReferences, TeacherReference createdBy, boolean isActive) {
		super();
		this.resourceId = resourceId;
		this.resourceType = resourceType;
		this.resourceName = resourceName;
		this.studyGuideReferences = studyGuideReferences;
		this.createdBy = createdBy;
		this.isActive = isActive;
	}

	public Resource() {

	}
}
