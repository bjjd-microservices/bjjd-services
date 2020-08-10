package com.jmk.upload.enums;

public enum ExcelDataType {
	LONG("LONG"),VARCHAR("VARCHAR"),DATE("DATE"),BOOLEAN("BOOLEAN"),DECIMAL("DECIMAL"),ENUMERATION("ENUMERATION");
	
	private final String type;
	
	private ExcelDataType(String type) {
		this.type=type;
	}
	
	public String getType() {
		return type;
	}
}

