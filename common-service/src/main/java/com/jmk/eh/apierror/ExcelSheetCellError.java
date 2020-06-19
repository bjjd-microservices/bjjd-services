package com.jmk.eh.apierror;

public class ExcelSheetCellError{
	
	private String columnName;
	private Object rejectedValue;
	private String message;
	
	
	/**
	 * @param rowNo
	 * @param columnName
	 * @param rejectedValue
	 * @param message
	 */
	public ExcelSheetCellError(String columnName, Object rejectedValue, String message) {
		super();
		this.columnName = columnName;
		this.rejectedValue = rejectedValue;
		this.message = message;
	}
	/**
	 * 
	 */
	public ExcelSheetCellError() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the columnName
	 */
	public String getColumnName() {
		return columnName;
	}
	/**
	 * @param columnName the columnName to set
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	/**
	 * @return the rejectedValue
	 */
	public Object getRejectedValue() {
		return rejectedValue;
	}
	/**
	 * @param rejectedValue the rejectedValue to set
	 */
	public void setRejectedValue(Object rejectedValue) {
		this.rejectedValue = rejectedValue;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
