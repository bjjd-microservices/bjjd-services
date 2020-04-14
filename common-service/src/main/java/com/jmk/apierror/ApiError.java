package com.jmk.apierror;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ApiError {

	private HttpStatus status;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timeStamp;

	private String message;

	private String debugMessage;

	private List<ApiSubError> subErrors;

	private ApiError() {
		this.timeStamp = LocalDateTime.now();
	}

	/**
	 * @param status
	 * @param message
	 */
	public ApiError(HttpStatus status, String message) {
		this();
		this.status = status;
		this.message = message;
	}

	public ApiError(HttpStatus status, Throwable ex) {
		this();
		this.status = status;
		this.message = "Unexpected error";
		this.debugMessage = ex.getLocalizedMessage();
	}

	public ApiError(HttpStatus status, String message, Throwable ex) {
		this();
		this.status = status;
		this.message = message;
		this.debugMessage = ex.getLocalizedMessage();
	}

	/**
	 * @param status
	 * @param timeStamp
	 * @param message
	 * @param debugMessage
	 * @param subErrors
	 */
	public ApiError(HttpStatus status, LocalDateTime timeStamp, String message, String debugMessage,
			List<ApiSubError> subErrors) {
		this();
		this.status = status;
		this.message = message;
		this.debugMessage = debugMessage;
	}

	/**
	 * @return the status
	 */
	public HttpStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	/**
	 * @return the timeStamp
	 */
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
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

	/**
	 * @return the debugMessage
	 */
	public String getDebugMessage() {
		return debugMessage;
	}

	/**
	 * @param debugMessage the debugMessage to set
	 */
	public void setDebugMessage(String debugMessage) {
		this.debugMessage = debugMessage;
	}

	/**
	 * @return the subErrors
	 */
	public List<ApiSubError> getSubErrors() {
		return subErrors;
	}

	/**
	 * @param subErrors the subErrors to set
	 */
	public void setSubErrors(List<ApiSubError> subErrors) {
		this.subErrors = subErrors;
	}
	
}
