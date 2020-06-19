package com.jmk.enums;

public enum ExcelFileErrorType {

	INVALID_DATE_VALUE("invalid.date.value"), INVALID_DECIMAL_VALUE("invalid.decimal.value"),
	INVALID_STRING_VALUE("invalid.string.Value"), ROW_REJECTED("row.rejected");

	private String errorType;

	/**
	 * @param errorType
	 */
	private ExcelFileErrorType(String errorType) {
		this.errorType = errorType;
	}

	/**
	 * @return the errorType
	 */
	public String getErrorType() {
		return errorType;
	}

}
