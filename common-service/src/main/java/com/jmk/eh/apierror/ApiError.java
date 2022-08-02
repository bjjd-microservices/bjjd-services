package com.jmk.eh.apierror;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;
import com.jmk.eh.exceptionhandler.LowerCaseClassNameResolver;


@JsonTypeIdResolver(LowerCaseClassNameResolver.class)
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.CUSTOM, property = "error", visible = true)
public class ApiError {

	private HttpStatus status;

	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	@JsonProperty("LocalDateTime")
	private LocalDateTime LocalDateTime;

	private String message;

	private String debugMessage;

	private List<ApiSubError> subErrors;

	private ApiError() {
		this.LocalDateTime = LocalDateTime.now();
	}
	
	public ApiError(HttpStatus status) {
		this();
		this.status = status;
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
	 * @param LocalDateTime
	 * @param message
	 * @param debugMessage
	 * @param subErrors
	 */
	public ApiError(HttpStatus status, LocalDateTime LocalDateTime, String message, String debugMessage,
			List<ApiSubError> subErrors) {
		this();
		this.status = status;
		this.message = message;
		this.debugMessage = debugMessage;
	}

	//Public Methods
	public void addValidationErrors(List<FieldError> fieldErrors) {
        fieldErrors.forEach(this::addValidationError);
    }
	
	public void addValidationError(List<ObjectError> globalErrors) {
        globalErrors.forEach(this::addValidationError);
    }
	
	public void addValidationErrors(Set<ConstraintViolation<?>> constraintViolations) {
        constraintViolations.forEach(this::addValidationError);
    }

	//Private methods
	public void addSubError(ApiSubError subError) {
		if (subErrors == null) {
			subErrors = new ArrayList<>();
		}
		subErrors.add(subError);
	}

	private void addValidationError(String object, String field, Object rejectedValue, String message) {
		addSubError(new ApiValidationError(object, field, rejectedValue, message));
	}

	private void addValidationError(String object, String message) {
		addSubError(new ApiValidationError(object, message));
	}

	private void addValidationError(FieldError fieldError) {
		this.addValidationError(fieldError.getObjectName(), fieldError.getField(), fieldError.getRejectedValue(),
				fieldError.getDefaultMessage());
	}

	private void addValidationError(ObjectError objectError) {
        this.addValidationError(
                objectError.getObjectName(),
                objectError.getDefaultMessage());
    }
	
	/**
     * Utility method for adding error of ConstraintViolation. Usually when a @Validated validation fails.
     *
     * @param cv the ConstraintViolation
     */
    private void addValidationError(ConstraintViolation<?> cv) {
        this.addValidationError(
                cv.getRootBeanClass().getSimpleName(),
                ((PathImpl) cv.getPropertyPath()).getLeafNode().asString(),
                cv.getInvalidValue(),
                cv.getMessage());
    }
	
	//Getter and Setters
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
	 * @return the LocalDateTime
	 */
	public LocalDateTime getLocalDateTime() {
		return LocalDateTime;
	}

	/**
	 * @param LocalDateTime the LocalDateTime to set
	 */
	public void setLocalDateTime(LocalDateTime LocalDateTime) {
		this.LocalDateTime = LocalDateTime;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((debugMessage == null) ? 0 : debugMessage.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((subErrors == null) ? 0 : subErrors.hashCode());
		result = prime * result + ((LocalDateTime == null) ? 0 : LocalDateTime.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApiError other = (ApiError) obj;
		if (debugMessage == null) {
			if (other.debugMessage != null)
				return false;
		} else if (!debugMessage.equals(other.debugMessage))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (status != other.status)
			return false;
		if (subErrors == null) {
			if (other.subErrors != null)
				return false;
		} else if (!subErrors.equals(other.subErrors))
			return false;
		if (LocalDateTime == null) {
			if (other.LocalDateTime != null)
				return false;
		} else if (!LocalDateTime.equals(other.LocalDateTime))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ApiError [status=" + status + ", LocalDateTime=" + LocalDateTime + ", message=" + message + ", debugMessage="
				+ debugMessage + ", subErrors=" + subErrors + "]";
	}
	
	
	
	//Getter and Setter
	

}
