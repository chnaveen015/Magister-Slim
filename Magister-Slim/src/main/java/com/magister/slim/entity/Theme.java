package com.magister.slim.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.magister.slim.references.StudyGuideReference;
import com.magister.slim.references.UnitReference;

@Document
public class Theme {

	@Id
	private String themeId;
	private String themeName;
	private String themeDescription;
	private String themeGoal;
	private StudyGuideReference studyGuideReference;
	private List<UnitReference> units;
	private boolean isActive;

	public Theme() {

	}
	
	public Theme( String themeName, String themeDescription, String themeGoal,
			StudyGuideReference studyGuideReference, List<UnitReference> units, boolean isActive) {
		super();
		this.themeName = themeName;
		this.themeDescription = themeDescription;
		this.themeGoal = themeGoal;
		this.studyGuideReference = studyGuideReference;
		this.units = units;
		this.isActive = isActive;
	}

	
	public String getThemeId() {
		return themeId;
	}

	public void setThemeId(String themeId) {
		this.themeId = themeId;
	}

	public String getThemeName() {
		return themeName;
	}

	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}

	public String getThemeDescription() {
		return themeDescription;
	}

	public void setThemeDescription(String themeDescription) {
		this.themeDescription = themeDescription;
	}

	public String getThemeGoal() {
		return themeGoal;
	}

	public void setThemeGoal(String themeGoal) {
		this.themeGoal = themeGoal;
	}

	public StudyGuideReference getStudyGuideReference() {
		return studyGuideReference;
	}

	public void setStudyGuideReference(StudyGuideReference studyGuideReference) {
		this.studyGuideReference = studyGuideReference;
	}

	public List<UnitReference> getUnits() {
		return units;
	}

	public void setUnits(List<UnitReference> list) {
		this.units = list;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Theme [themeId=" + themeId + ", themeName=" + themeName + ", themeDescription=" + themeDescription
				+ ", themeGoal=" + themeGoal + ", studyGuideReference=" + studyGuideReference + ", units=" + units
				+ ", isActive=" + isActive + "]";
	}


	
}
