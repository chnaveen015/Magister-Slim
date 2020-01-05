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
	public Assignment(String assignmentId, String assignmentName, String validOnwards, String validUpto,
			List<StudentReference> students, List<AssignmentResultReference> assignmentResultReference,
			boolean isActive, UnitReference unitReference, StudyGuideReference studyGuideReference,
			TeacherReference createdBy) {
		super();
		this.assignmentId = assignmentId;
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
	@Override
	public String toString() {
		return "Assignment [assignmentId=" + assignmentId + ", assignmentName=" + assignmentName + ", validOnwards="
				+ validOnwards + ", validUpto=" + validUpto + ", students=" + students + ", assignmentResultReference="
				+ assignmentResultReference + ", isActive=" + isActive + ", unitReference=" + unitReference
				+ ", studyGuideReference=" + studyGuideReference + ", createdBy=" + createdBy + "]";
	}
	
	public Assignment()
	{
		
	}
	
	

	
}
