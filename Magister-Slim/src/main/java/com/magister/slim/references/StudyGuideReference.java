package com.magister.slim.references;

import org.springframework.data.annotation.Id;

public class StudyGuideReference {

	@Id
	private String studyGuideId;
	private String studyGuideName;
	private String themeId;
	private String unitId;
	private boolean isActive;

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getThemeId() {
		return themeId;
	}

	public void setThemeId(String themeId) {
		this.themeId = themeId;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getStudyGuideId() {
		return studyGuideId;
	}

	public void setStudyGuideId(String studyGuideId) {
		this.studyGuideId = studyGuideId;
	}

	public String getStudyGuideName() {
		return studyGuideName;
	}

	public void setStudyGuideName(String studyGuideName) {
		this.studyGuideName = studyGuideName;
	}

	public StudyGuideReference(String studyGuideId, String studyGuideName, String themeId, String unitId,
			boolean isActive) {
		super();
		this.studyGuideId = studyGuideId;
		this.studyGuideName = studyGuideName;
		this.themeId = themeId;
		this.unitId = unitId;
		this.isActive = isActive;
	}
	
	public StudyGuideReference(String studyGuideId, String studyGuideName,boolean isActive) {
		super();
		this.studyGuideId = studyGuideId;
		this.studyGuideName = studyGuideName;
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "StudyGuideReference [studyGuideId=" + studyGuideId + ", studyGuideName=" + studyGuideName + ", themeId="
				+ themeId + ", unitId=" + unitId + ", isActive=" + isActive + "]";
	}

	public StudyGuideReference() {

	}

}
