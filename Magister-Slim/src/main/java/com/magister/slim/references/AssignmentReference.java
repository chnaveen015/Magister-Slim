package com.magister.slim.references;

public class AssignmentReference {

	private String assignmentId;
	private String assignmentName;
	private boolean isActive;

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

	@Override
	public String toString() {
		return "AssignmentReference [assignmentId=" + assignmentId + ", assignmentName=" + assignmentName + "]";
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
