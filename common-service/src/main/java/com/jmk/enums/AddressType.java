package com.jmk.enums;

public enum AddressType {

	PERMANENT("Permanent"),MAILING("Mailing");
	
	String type;
	
	private AddressType(String type) {
		this.type=type;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	
	
	
}
