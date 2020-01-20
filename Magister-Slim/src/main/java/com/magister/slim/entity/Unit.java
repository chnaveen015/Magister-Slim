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
	private String unitDescription;
	private String unitGoal;
	private List<AssignmentReference> assignments;
	private List<ResourceReference> resources;
	private ThemeReference themeReference;
	private StudyGuideReference studyGuideReference;
	private boolean active;

	public Unit() {

	}
	
	public Unit( String unitName, String unitDescription, String unitGoal,
			List<AssignmentReference> assignments, List<ResourceReference> resources, ThemeReference themeReference,
			StudyGuideReference studyGuideReference, boolean active) {
		super();
		this.unitName = unitName;
		this.unitDescription = unitDescription;
		this.unitGoal = unitGoal;
		this.assignments = assignments;
		this.resources = resources;
		this.themeReference = themeReference;
		this.studyGuideReference = studyGuideReference;
		this.active = active;
	}
	
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

	public String getUnitDescription() {
		return unitDescription;
	}

	public void setUnitDescription(String unitDescription) {
		this.unitDescription = unitDescription;
	}

	public String getUnitGoal() {
		return unitGoal;
	}

	public void setUnitGoal(String unitGoal) {
		this.unitGoal = unitGoal;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + ((assignments == null) ? 0 : assignments.hashCode());
		result = prime * result + ((resources == null) ? 0 : resources.hashCode());
		result = prime * result + ((studyGuideReference == null) ? 0 : studyGuideReference.hashCode());
		result = prime * result + ((themeReference == null) ? 0 : themeReference.hashCode());
		result = prime * result + ((unitDescription == null) ? 0 : unitDescription.hashCode());
		result = prime * result + ((unitGoal == null) ? 0 : unitGoal.hashCode());
		result = prime * result + ((unitId == null) ? 0 : unitId.hashCode());
		result = prime * result + ((unitName == null) ? 0 : unitName.hashCode());
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
		Unit other = (Unit) obj;
		if (active != other.active)
			return false;
		if (assignments == null) {
			if (other.assignments != null)
				return false;
		} else if (!assignments.equals(other.assignments))
			return false;
		if (resources == null) {
			if (other.resources != null)
				return false;
		} else if (!resources.equals(other.resources))
			return false;
		if (studyGuideReference == null) {
			if (other.studyGuideReference != null)
				return false;
		} else if (!studyGuideReference.equals(other.studyGuideReference))
			return false;
		if (themeReference == null) {
			if (other.themeReference != null)
				return false;
		} else if (!themeReference.equals(other.themeReference))
			return false;
		if (unitDescription == null) {
			if (other.unitDescription != null)
				return false;
		} else if (!unitDescription.equals(other.unitDescription))
			return false;
		if (unitGoal == null) {
			if (other.unitGoal != null)
				return false;
		} else if (!unitGoal.equals(other.unitGoal))
			return false;
		if (unitId == null) {
			if (other.unitId != null)
				return false;
		} else if (!unitId.equals(other.unitId))
			return false;
		if (unitName == null) {
			if (other.unitName != null)
				return false;
		} else if (!unitName.equals(other.unitName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Unit [unitId=" + unitId + ", unitName=" + unitName + ", unitDescription=" + unitDescription
				+ ", unitGoal=" + unitGoal + ", assignments=" + assignments + ", resources=" + resources
				+ ", themeReference=" + themeReference + ", studyGuideReference=" + studyGuideReference + ", active="
				+ active + "]";
	}

	


}
