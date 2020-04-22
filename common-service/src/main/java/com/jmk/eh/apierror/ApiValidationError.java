package com.jmk.eh.apierror;

public class ApiValidationError extends ApiSubError {

	private String 	object;
	private String field;
	private Object rejectedValue;
	private String message;
	
	 public ApiValidationError(String object, String message) {
	        this.object = object;
	        this.message = message;
	 }

	/**
	 * @param object
	 * @param field
	 * @param rejectedValue
	 * @param message
	 */
	public ApiValidationError(String object, String field, Object rejectedValue, String message) {
		super();
		this.object = object;
		this.field = field;
		this.rejectedValue = rejectedValue;
		this.message = message;
	}



	/**
	 * @return the object
	 */
	public String getObject() {
		return object;
	}

	/**
	 * @param object the object to set
	 */
	public void setObject(String object) {
		this.object = object;
	}

	/**
	 * @return the field
	 */
	public String getField() {
		return field;
	}

	/**
	 * @param field the field to set
	 */
	public void setField(String field) {
		this.field = field;
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
