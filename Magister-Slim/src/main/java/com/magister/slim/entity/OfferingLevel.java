package com.magister.slim.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.magister.slim.references.CourseReference;
import com.magister.slim.references.OfferingReference;

@Document
public class OfferingLevel {

	@Id
	private String offeringLevelId;
	private String offeringLevelName;
	private OfferingReference offeringReference;
	private List<CourseReference> courseReferences;
	private boolean isActive;

	public OfferingLevel() {

	}

	public OfferingLevel( String offeringLevelName, OfferingReference offeringReference,
			List<CourseReference> courseReferences, boolean isActive) {
		super();
		this.offeringLevelName = offeringLevelName;
		this.offeringReference = offeringReference;
		this.courseReferences = courseReferences;
		this.isActive = isActive;
	}
	
	public String getOfferingLevelId() {
		return offeringLevelId;
	}

	public void setOfferingLevelId(String offeringLevelId) {
		this.offeringLevelId = offeringLevelId;
	}

	public String getOfferingLevelName() {
		return offeringLevelName;
	}

	public void setOfferingLevelName(String offeringLevelName) {
		this.offeringLevelName = offeringLevelName;
	}

	public OfferingReference getOfferingReference() {
		return offeringReference;
	}

	public void setOfferingReference(OfferingReference offeringReference) {
		this.offeringReference = offeringReference;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	
	public List<CourseReference> getCourseReferences() {
		return courseReferences;
	}

	public void setCourseReferences(List<CourseReference> courseReferences) {
		this.courseReferences = courseReferences;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseReferences == null) ? 0 : courseReferences.hashCode());
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + ((offeringLevelId == null) ? 0 : offeringLevelId.hashCode());
		result = prime * result + ((offeringLevelName == null) ? 0 : offeringLevelName.hashCode());
		result = prime * result + ((offeringReference == null) ? 0 : offeringReference.hashCode());
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
		OfferingLevel other = (OfferingLevel) obj;
		if (courseReferences == null) {
			if (other.courseReferences != null)
				return false;
		} else if (!courseReferences.equals(other.courseReferences))
			return false;
		if (isActive != other.isActive)
			return false;
		if (offeringLevelId == null) {
			if (other.offeringLevelId != null)
				return false;
		} else if (!offeringLevelId.equals(other.offeringLevelId))
			return false;
		if (offeringLevelName == null) {
			if (other.offeringLevelName != null)
				return false;
		} else if (!offeringLevelName.equals(other.offeringLevelName))
			return false;
		if (offeringReference == null) {
			if (other.offeringReference != null)
				return false;
		} else if (!offeringReference.equals(other.offeringReference))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OfferingLevel [offeringLevelId=" + offeringLevelId + ", offeringLevelName=" + offeringLevelName
				+ ", offeringReference=" + offeringReference + ", courseReferences=" + courseReferences + ", isActive="
				+ isActive + "]";
	}

}
