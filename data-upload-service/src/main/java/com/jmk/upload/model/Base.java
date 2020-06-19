package com.jmk.upload.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.jmk.eh.apierror.ExcelSheetCellError;

@XmlRootElement
@XmlSeeAlso(Project.class)
public class Base implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6496493438753020753L;

	@XmlTransient
	@JsonIgnore
	private Errors errors;

	private long row;

	/**
	 * @return the errors
	 */
	@XmlTransient
	public Errors getErrors() {
		return errors;
	}

	/**
	 * @param errors the errors to set
	 */
	public void setErrors(Errors errors) {
		this.errors = errors;
	}

	/**
	 * @return the row
	 */
	public long getRow() {
		return row;
	}

	/**
	 * @param row the row to set
	 */
	public void setRow(long row) {
		this.row = row;
	}
	
	@JsonRawValue
	public String getError(){
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		if(errors !=null && this.errors.hasErrors()){
			for(FieldError fieldError: errors.getFieldErrors() )
			{
				String objectName=fieldError.getObjectName();
				builder.append("{ \"Row No \":"+objectName+",\"column\" : \""+fieldError.getField()+"\",\"rejectedValue\""
						+ ":\""+fieldError.getRejectedValue()+" / "+fieldError.getDefaultMessage());
				builder.append("\",\"message\":\""+fieldError.getDefaultMessage()+" / Invalid Value "+"\"},");
			}
			builder.replace(builder.lastIndexOf(","), builder.length(), "");
		}
		builder.append("]");
		
		return builder.toString();
	}
	
	public Map<String, List<ExcelSheetCellError>> getExcelSheetRowErrors() {
		Map<String, List<ExcelSheetCellError>> rowErrorsMapping = new HashMap<>();

		if (errors != null && this.errors.hasErrors()) {
			List<ExcelSheetCellError> excelSheetCellErrors = new ArrayList<>();
			String rowNo = null;
			for (FieldError fieldError : errors.getFieldErrors()) {
				rowNo = fieldError.getObjectName();
				excelSheetCellErrors.add(new ExcelSheetCellError(fieldError.getField(),
						fieldError.getRejectedValue(), fieldError.getDefaultMessage()));
			}
			rowErrorsMapping.put("rowNo:"+rowNo, excelSheetCellErrors);
		}

		return rowErrorsMapping;
	}

}
