package com.jmk.user.enums;

public enum Group {
	BJJD(9,"BJJD"),BJJDJKYV(19,"BJJDJKYV");
	
	private Group(int groupId,String groupName) {
		this.groupId=groupId;
		this.groupName=groupName;
	}
	
	int groupId;
	
	String groupName;
	
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	
}
