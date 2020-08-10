package com.jmk.eh.apierror;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExcelSheetValidationError extends ApiSubError{
	
	/**
	 * 
	 */
	@JsonProperty("sheetErrors")
	private Map<String,List<Map<String,List<ExcelSheetCellError>>>> sheetErrorsMapping=new HashMap<>();
	
	
	public void addSheetRowErrors(String sheetName,Map<String,List<ExcelSheetCellError>> rowErrorsMapping) {
		if(sheetErrorsMapping.containsKey(sheetName)) {
			sheetErrorsMapping.get(sheetName).add(rowErrorsMapping);
		}else {
			List<Map<String,List<ExcelSheetCellError>>> rowsError=new ArrayList<>();
			rowsError.add(rowErrorsMapping);
			sheetErrorsMapping.put(sheetName,rowsError);
		}
	}


	/**
	 * @return the sheetErrorsMapping
	 */
	public Map<String, List<Map<String, List<ExcelSheetCellError>>>> getSheetErrorsMapping() {
		return sheetErrorsMapping;
	}


	/**
	 * @param sheetErrorsMapping the sheetErrorsMapping to set
	 */
	public void setSheetErrorsMapping(Map<String, List<Map<String, List<ExcelSheetCellError>>>> sheetErrorsMapping) {
		this.sheetErrorsMapping = sheetErrorsMapping;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ExcelSheetValidationError [sheetErrorsMapping=" + sheetErrorsMapping + "]";
	}


	
	


}
