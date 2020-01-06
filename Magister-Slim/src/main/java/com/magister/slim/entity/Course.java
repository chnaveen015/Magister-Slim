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

	public Course()
	{
		
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

	public Course(String courseId, String courseName, List<StudyGuideReference> studyGuideReferences,
			List<GroupReference> groupReferences, OfferingLevelReference offeringLevelReference, boolean isActive) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.studyGuideReferences = studyGuideReferences;
		this.groupReferences = groupReferences;
		this.offeringLevelReference = offeringLevelReference;
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", studyGuideReferences="
				+ studyGuideReferences + ", groupReferences=" + groupReferences + ", offeringLevelReference="
				+ offeringLevelReference + ", isActive=" + isActive + "]";
	}
	

}
