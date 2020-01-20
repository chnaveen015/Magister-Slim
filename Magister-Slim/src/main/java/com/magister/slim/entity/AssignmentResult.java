package com.magister.slim.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.magister.slim.references.AssignmentReference;
import com.magister.slim.references.StudentReference;

@Document
public class AssignmentResult {

	@Id
	private String assignmentResultId;
	private StudentReference studentReference;
	private AssignmentReference assignmentReference;
	private int assignedMarks;
	private int totalmarks;
	
	public AssignmentResult() {

	}
	
	public AssignmentResult( StudentReference studentReference,
			AssignmentReference assignmentReference, int assignedMarks, int totalmarks) {
		super();
		this.studentReference = studentReference;
		this.assignmentReference = assignmentReference;
		this.assignedMarks = assignedMarks;
		this.totalmarks = totalmarks;
	}

	public String getAssignmentResultId() {
		return assignmentResultId;
	}

	public void setAssignmentResultId(String assignmentResultId) {
		this.assignmentResultId = assignmentResultId;
	}

	public StudentReference getStudentReference() {
		return studentReference;
	}

	public void setStudentReference(StudentReference studentReference) {
		this.studentReference = studentReference;
	}

	public AssignmentReference getAssignmentReference() {
		return assignmentReference;
	}

	public void setAssignmentReference(AssignmentReference list) {
		this.assignmentReference = list;
	}

	public int getAssignedMarks() {
		return assignedMarks;
	}

	public void setAssignedMarks(int assignedMarks) {
		this.assignedMarks = assignedMarks;
	}

	public int getTotalmarks() {
		return totalmarks;
	}

	public void setTotalmarks(int totalmarks) {
		this.totalmarks = totalmarks;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + assignedMarks;
		result = prime * result + ((assignmentReference == null) ? 0 : assignmentReference.hashCode());
		result = prime * result + ((assignmentResultId == null) ? 0 : assignmentResultId.hashCode());
		result = prime * result + ((studentReference == null) ? 0 : studentReference.hashCode());
		result = prime * result + totalmarks;
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
		AssignmentResult other = (AssignmentResult) obj;
		if (assignedMarks != other.assignedMarks)
			return false;
		if (assignmentReference == null) {
			if (other.assignmentReference != null)
				return false;
		} else if (!assignmentReference.equals(other.assignmentReference))
			return false;
		if (assignmentResultId == null) {
			if (other.assignmentResultId != null)
				return false;
		} else if (!assignmentResultId.equals(other.assignmentResultId))
			return false;
		if (studentReference == null) {
			if (other.studentReference != null)
				return false;
		} else if (!studentReference.equals(other.studentReference))
			return false;
		if (totalmarks != other.totalmarks)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AssignmentResult [assignmentResultId=" + assignmentResultId + ", studentReference=" + studentReference
				+ ", assignmentReference=" + assignmentReference + ", assignedMarks=" + assignedMarks + ", totalmarks="
				+ totalmarks + "]";
	}





}
