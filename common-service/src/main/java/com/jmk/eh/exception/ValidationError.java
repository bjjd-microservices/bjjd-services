package com.jmk.eh.exception;

import com.jmk.eh.apierror.ApiSubError;

public class ValidationError extends ApiSubError{
	private String sheetName;
	private int rowNo;
	private String columnName;
	private String rejectedValue;
	private String message;
	
}
