package com.jmk.eh.exception;

import org.apache.commons.lang.StringUtils;

public class StatusNotActiveException extends RuntimeException {

	private static final long serialVersionUID = 2555321976707340233L;

	public StatusNotActiveException(Exception exception) {
		super(exception);
	}
	
	@SuppressWarnings("rawtypes")
	public StatusNotActiveException(Class clazz,String key,String value) {
		super(String.format("Status of the %s having [%s=%s] is not active", StringUtils.capitalize(clazz.getSimpleName()),key,value));
	}
	
}


