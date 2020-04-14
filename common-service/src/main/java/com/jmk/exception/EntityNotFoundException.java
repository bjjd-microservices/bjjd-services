package com.jmk.exception;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class EntityNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2555321976707340233L;

	public EntityNotFoundException(Exception exception) {
		super(exception);
	}
	
	public EntityNotFoundException(Class clazz,String... searchParamsMap) {
		
	}
	
	/**
	 * Generate the error message
	 * @param entity
	 * @param searchParams
	 * @return the string message
	 */
	private String generateMessage(String entity,Map<String,String> searchParams) {
		return StringUtils.capitalize(entity)+" was not found for parameters "+searchParams;
	}
	
	
	private static 	<K,V> Map<K,V> toMap(Class<K> keyType,Class<V> valueType,Object... entries){
		if(entries.length%2==1) {
			throw new IllegalArgumentException("Invalid entries");
		}
		return null;
	}
}


