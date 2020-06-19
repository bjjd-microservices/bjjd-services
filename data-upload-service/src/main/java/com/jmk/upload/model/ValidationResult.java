package com.jmk.upload.model;

import java.util.List;
import java.util.Map;

import com.jmk.enums.Result;

public class ValidationResult {

	private Result result;
	
	private Map<String, List<? extends Base>> sheetResultMapping;

	/**
	 * @return the result
	 */
	public Result getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(Result result) {
		this.result = result;
	}

	/**
	 * @return the sheetResultMapping
	 */
	public Map<String, List<? extends Base>> getSheetResultMapping() {
		return sheetResultMapping;
	}

	/**
	 * @param sheetResultMapping the sheetResultMapping to set
	 */
	public void setSheetResultMapping(Map<String, List<? extends Base>> sheetResultMapping) {
		this.sheetResultMapping = sheetResultMapping;
	}
	
}
