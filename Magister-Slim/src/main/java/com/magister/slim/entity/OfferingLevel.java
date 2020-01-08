<<<<<<< HEAD
package com.magister.slim.entity;

import java.util.List; 

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.magister.slim.references.CourseReference;
import com.magister.slim.references.GroupReference;
import com.magister.slim.references.OfferingReference;

@Document
public class OfferingLevel {
	
	@Id
	private String offeringLevelId;
	private String offeringLevelName;
	private OfferingReference offeringReference;
	private List<CourseReference> courseReferences;
	private boolean isActive;
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

	
	public OfferingLevel()
	{
		
	}
	public List<CourseReference> getCourseReferences() {
		return courseReferences;
	}
	public void setCourseReferences(List<CourseReference> courseReferences) {
		this.courseReferences = courseReferences;
	}
	public OfferingLevel(String offeringLevelId, String offeringLevelName, OfferingReference offeringReference,
			List<CourseReference> courseReferences, boolean isActive) {
		super();
		this.offeringLevelId = offeringLevelId;
		this.offeringLevelName = offeringLevelName;
		this.offeringReference = offeringReference;
		this.courseReferences = courseReferences;
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "OfferingLevel [offeringLevelId=" + offeringLevelId + ", offeringLevelName=" + offeringLevelName
				+ ", offeringReference=" + offeringReference + ", courseReferences=" + courseReferences + ", isActive="
				+ isActive + "]";
	}
	

}
=======
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

	
	public OfferingLevel()
	{
		
	}
	public List<CourseReference> getCourseReferences() {
		return courseReferences;
	}
	public void setCourseReferences(List<CourseReference> courseReferences) {
		this.courseReferences = courseReferences;
	}
	public OfferingLevel(String offeringLevelId, String offeringLevelName, OfferingReference offeringReference,
			List<CourseReference> courseReferences, boolean isActive) {
		super();
		this.offeringLevelId = offeringLevelId;
		this.offeringLevelName = offeringLevelName;
		this.offeringReference = offeringReference;
		this.courseReferences = courseReferences;
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "OfferingLevel [offeringLevelId=" + offeringLevelId + ", offeringLevelName=" + offeringLevelName
				+ ", offeringReference=" + offeringReference + ", courseReferences=" + courseReferences + ", isActive="
				+ isActive + "]";
	}
	

}
>>>>>>> Removed Cross Origins
