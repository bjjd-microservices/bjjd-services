package com.jmk.eh.exception;

import com.jmk.eh.apierror.ApiError;

public class ExcelSheetValidationException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3152830431837679394L;
	private ApiError apiError;
	
	public ExcelSheetValidationException() {
		super();
	}
	
	public ExcelSheetValidationException(ApiError apiError) {
		this.apiError=apiError;
	}

	/**
	 * @return the apiError
	 */
	public ApiError getApiError() {
		return apiError;
	}

	/**
	 * @param apiError the apiError to set
	 */
	public void setApiError(ApiError apiError) {
		this.apiError = apiError;
	}
	
	
	

}
