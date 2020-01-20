package com.magister.slim.entity;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.magister.slim.references.AssignmentResultReference;
import com.magister.slim.references.StudentReference;
import com.magister.slim.references.StudyGuideReference;
import com.magister.slim.references.TeacherReference;
import com.magister.slim.references.UnitReference;

@Document
public class Assignment {
	@Id
	private String assignmentId;
	private String assignmentName;
	private String validOnwards;
	private String validUpto;
	private List<StudentReference> students;
	private List<AssignmentResultReference> assignmentResultReference;
	private boolean isActive;
	private UnitReference unitReference;
	private StudyGuideReference studyGuideReference;
	private TeacherReference createdBy;
	
	public Assignment() {
		
	}

	public Assignment(String assignmentName, String validOnwards, String validUpto, List<StudentReference> students,
			List<AssignmentResultReference> assignmentResultReference, boolean isActive, UnitReference unitReference,
			StudyGuideReference studyGuideReference, TeacherReference createdBy) {
		super();
		this.assignmentName = assignmentName;
		this.validOnwards = validOnwards;
		this.validUpto = validUpto;
		this.students = students;
		this.assignmentResultReference = assignmentResultReference;
		this.isActive = isActive;
		this.unitReference = unitReference;
		this.studyGuideReference = studyGuideReference;
		this.createdBy = createdBy;
	}

	public String getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(String assignmentId) {
		this.assignmentId = assignmentId;
	}

	public String getAssignmentName() {
		return assignmentName;
	}

	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}

	public String getValidOnwards() {
		return validOnwards;
	}

	public void setValidOnwards(String validOnwards) {
		this.validOnwards = validOnwards;
	}

	public String getValidUpto() {
		return validUpto;
	}

	public void setValidUpto(String validUpto) {
		this.validUpto = validUpto;
	}

	public List<StudentReference> getStudents() {
		return students;
	}

	public void setStudents(List<StudentReference> students) {
		this.students = students;
	}

	public List<AssignmentResultReference> getAssignmentResultReference() {
		return assignmentResultReference;
	}

	public void setAssignmentResultReference(List<AssignmentResultReference> assignmentResultReference) {
		this.assignmentResultReference = assignmentResultReference;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public UnitReference getUnitReference() {
		return unitReference;
	}

	public void setUnitReference(UnitReference unitReference) {
		this.unitReference = unitReference;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assignmentId == null) ? 0 : assignmentId.hashCode());
		result = prime * result + ((assignmentName == null) ? 0 : assignmentName.hashCode());
		result = prime * result + ((assignmentResultReference == null) ? 0 : assignmentResultReference.hashCode());
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + ((students == null) ? 0 : students.hashCode());
		result = prime * result + ((studyGuideReference == null) ? 0 : studyGuideReference.hashCode());
		result = prime * result + ((unitReference == null) ? 0 : unitReference.hashCode());
		result = prime * result + ((validOnwards == null) ? 0 : validOnwards.hashCode());
		result = prime * result + ((validUpto == null) ? 0 : validUpto.hashCode());
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
		Assignment other = (Assignment) obj;
		if (assignmentId == null) {
			if (other.assignmentId != null)
				return false;
		} else if (!assignmentId.equals(other.assignmentId))
			return false;
		if (assignmentName == null) {
			if (other.assignmentName != null)
				return false;
		} else if (!assignmentName.equals(other.assignmentName))
			return false;
		if (assignmentResultReference == null) {
			if (other.assignmentResultReference != null)
				return false;
		} else if (!assignmentResultReference.equals(other.assignmentResultReference))
			return false;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (isActive != other.isActive)
			return false;
		if (students == null) {
			if (other.students != null)
				return false;
		} else if (!students.equals(other.students))
			return false;
		if (studyGuideReference == null) {
			if (other.studyGuideReference != null)
				return false;
		} else if (!studyGuideReference.equals(other.studyGuideReference))
			return false;
		if (unitReference == null) {
			if (other.unitReference != null)
				return false;
		} else if (!unitReference.equals(other.unitReference))
			return false;
		if (validOnwards == null) {
			if (other.validOnwards != null)
				return false;
		} else if (!validOnwards.equals(other.validOnwards))
			return false;
		if (validUpto == null) {
			if (other.validUpto != null)
				return false;
		} else if (!validUpto.equals(other.validUpto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Assignment [assignmentId=" + assignmentId + ", assignmentName=" + assignmentName + ", validOnwards="
				+ validOnwards + ", validUpto=" + validUpto + ", students=" + students + ", assignmentResultReference="
				+ assignmentResultReference + ", isActive=" + isActive + ", unitReference=" + unitReference
				+ ", studyGuideReference=" + studyGuideReference + ", createdBy=" + createdBy + "]";
	}
	
	

}
