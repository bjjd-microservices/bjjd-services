package com.jmk.eh.exception;

public class StatusNotActiveException extends RuntimeException {

	private static final long serialVersionUID = 2555321976707340233L;

	public StatusNotActiveException() {
	}
	
	public StatusNotActiveException(Exception exception) {
		super(exception);
	}
	
	@SuppressWarnings("rawtypes")
	public StatusNotActiveException(Class clazz,String key,String value) {
		super(String.format("Status of the %s having [%s=%s] is not active", org.springframework.util.StringUtils.capitalize(clazz.getSimpleName()),key,value));
	}
	
}


