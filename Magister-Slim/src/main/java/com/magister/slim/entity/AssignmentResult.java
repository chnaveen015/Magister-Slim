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
	public String toString() {
		return "AssignmentResult [assignmentResultId=" + assignmentResultId + ", studentReference=" + studentReference
				+ ", assignmentReference=" + assignmentReference + ", assignedMarks=" + assignedMarks + ", totalmarks="
				+ totalmarks + "]";
	}

	public AssignmentResult(String assignmentResultId, StudentReference studentReference,
			AssignmentReference assignmentReference, int assignedMarks, int totalmarks) {
		super();
		this.assignmentResultId = assignmentResultId;
		this.studentReference = studentReference;
		this.assignmentReference = assignmentReference;
		this.assignedMarks = assignedMarks;
		this.totalmarks = totalmarks;
	}

	public AssignmentResult() {

	}

}
