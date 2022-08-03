package com.jmk.people.enums;

public enum PersonType {
	MEMBER("Member"),SEVADAR("Sevadar"),DEVOTEE("Devotee");
	
	String type;

	private PersonType(String type) {
		this.type = type;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

}
