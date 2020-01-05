package com.magister.slim.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.magister.slim.references.AssignmentReference;
import com.magister.slim.references.ResourceReference;
import com.magister.slim.references.StudyGuideReference;
import com.magister.slim.references.ThemeReference;

@Document
public class Unit {

	@Id
	private String unitId;
	private String unitName;
	private List<AssignmentReference> assignments;
	private List<ResourceReference> resources;
	private ThemeReference themeReference;
	private StudyGuideReference studyGuideReference;
	private boolean active;

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public List<AssignmentReference> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<AssignmentReference> assignments) {
		this.assignments = assignments;
	}

	public List<ResourceReference> getResources() {
		return resources;
	}

	public void setResources(List<ResourceReference> resources) {
		this.resources = resources;
	}

	public ThemeReference getThemeReference() {
		return themeReference;
	}

	public void setThemeReference(ThemeReference themeReference) {
		this.themeReference = themeReference;
	}

	public StudyGuideReference getStudyGuideReference() {
		return studyGuideReference;
	}

	public void setStudyGuideReference(StudyGuideReference studyGuideReference) {
		this.studyGuideReference = studyGuideReference;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Unit [unitId=" + unitId + ", unitName=" + unitName + ", assignments=" + assignments + ", resources="
				+ resources + ", themeReference=" + themeReference + ", studyGuideReference=" + studyGuideReference
				+ ", active=" + active + "]";
	}

	public Unit(String unitId, String unitName, List<AssignmentReference> assignments, List<ResourceReference> resources,
			ThemeReference themeReference, StudyGuideReference studyGuideReference, boolean active) {
		super();
		this.unitId = unitId;
		this.unitName = unitName;
		this.assignments = assignments;
		this.resources = resources;
		this.themeReference = themeReference;
		this.studyGuideReference = studyGuideReference;
		this.active = active;
	}
	public Unit()
	{
		
	}
}
