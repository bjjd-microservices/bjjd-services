package com.jmk.eh.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import org.apache.commons.lang.StringUtils;

public class EntityNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2555321976707340233L;

	public EntityNotFoundException(Exception exception) {
		super(exception);
	}
	
	@SuppressWarnings("rawtypes")
	public EntityNotFoundException(Class clazz,String... searchParamsMap) {
		super(generateMessage(clazz.getSimpleName(),toMap(String.class,String.class,searchParamsMap)));
	}
	
	/**
	 * Generate the error message
	 * @param entity
	 * @param searchParams
	 * @return the string message
	 */
	private static String generateMessage(String entity,Map<String,String> searchParams) {
		return StringUtils.capitalize(entity)+" was not found for parameters "+searchParams;
	}
	
	
	/**
	 * To map
	 * @param keyType
	 * @param valueType
	 * @param entries
	 * @return
	 */
	private static <K, V> Map<K, V> toMap(Class<K> keyType, Class<V> valueType, Object... entries) {
		if (entries.length % 2 == 1) {
			throw new IllegalArgumentException("Invalid entries");
		}
		return IntStream.range(0, entries.length / 2).map(i -> i * 2).collect(HashMap::new,
				(m, i) -> m.put(keyType.cast(entries[i]), valueType.cast(entries[i + 1])), Map::putAll);
	}
}


