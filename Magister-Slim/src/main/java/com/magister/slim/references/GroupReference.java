package com.magister.slim.references;

public class GroupReference {
	
	private String groupId;
	private String groupName;
	private boolean isActive;
	
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public GroupReference(String groupId, String groupName, boolean isActive) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "GroupReference [groupId=" + groupId + ", groupName=" + groupName + ", isActive=" + isActive + "]";
	}
	public GroupReference()
	{
		
	}
	

}
