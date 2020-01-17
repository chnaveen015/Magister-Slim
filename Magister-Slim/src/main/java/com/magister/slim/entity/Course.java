package com.magister.slim.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.magister.slim.references.GroupReference;
import com.magister.slim.references.OfferingLevelReference;
import com.magister.slim.references.StudyGuideReference;

@Document
public class Course {

	@Id
	private String courseId;
	private String courseName;
	private List<StudyGuideReference> studyGuideReferences;
	private List<GroupReference> groupReferences;
	private OfferingLevelReference offeringLevelReference;
	private boolean isActive;

	public Course() {

	}
	
	public Course( String courseName, List<StudyGuideReference> studyGuideReferences,
			List<GroupReference> groupReferences, OfferingLevelReference offeringLevelReference, boolean isActive) {
		super();
		this.courseName = courseName;
		this.studyGuideReferences = studyGuideReferences;
		this.groupReferences = groupReferences;
		this.offeringLevelReference = offeringLevelReference;
		this.isActive = isActive;
	}


	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public List<StudyGuideReference> getStudyGuideReferences() {
		return studyGuideReferences;
	}

	public void setStudyGuideReferences(List<StudyGuideReference> studyGuideReferences) {
		this.studyGuideReferences = studyGuideReferences;
	}

	public List<GroupReference> getGroupReferences() {
		return groupReferences;
	}

	public void setGroupReferences(List<GroupReference> groupReferences) {
		this.groupReferences = groupReferences;
	}

	public OfferingLevelReference getOfferingLevelReference() {
		return offeringLevelReference;
	}

	public void setOfferingLevelReference(OfferingLevelReference offeringLevelReference) {
		this.offeringLevelReference = offeringLevelReference;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseId == null) ? 0 : courseId.hashCode());
		result = prime * result + ((courseName == null) ? 0 : courseName.hashCode());
		result = prime * result + ((groupReferences == null) ? 0 : groupReferences.hashCode());
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + ((offeringLevelReference == null) ? 0 : offeringLevelReference.hashCode());
		result = prime * result + ((studyGuideReferences == null) ? 0 : studyGuideReferences.hashCode());
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
		Course other = (Course) obj;
		if (courseId == null) {
			if (other.courseId != null)
				return false;
		} else if (!courseId.equals(other.courseId))
			return false;
		if (courseName == null) {
			if (other.courseName != null)
				return false;
		} else if (!courseName.equals(other.courseName))
			return false;
		if (groupReferences == null) {
			if (other.groupReferences != null)
				return false;
		} else if (!groupReferences.equals(other.groupReferences))
			return false;
		if (isActive != other.isActive)
			return false;
		if (offeringLevelReference == null) {
			if (other.offeringLevelReference != null)
				return false;
		} else if (!offeringLevelReference.equals(other.offeringLevelReference))
			return false;
		if (studyGuideReferences == null) {
			if (other.studyGuideReferences != null)
				return false;
		} else if (!studyGuideReferences.equals(other.studyGuideReferences))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", studyGuideReferences="
				+ studyGuideReferences + ", groupReferences=" + groupReferences + ", offeringLevelReference="
				+ offeringLevelReference + ", isActive=" + isActive + "]";
	}

}
