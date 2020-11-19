package com.jmk.upload.template;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ExcelSheetTemplate implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3436559113592808359L;

	private int templateId;
	
	private String templateName;
	
	private int headerRowsSize;
	
	private int processRowsPerThread;
	
	private String templateClass;
	
	private String validatorClass;
	
	private List<ColumnTemplate> columnTemplates=new ArrayList<>();
	
	private Map<Integer, ColumnTemplate> columnTemplatesMap;
	
	/**
	 * @return the templateId
	 */
	public long getTemplateId() {
		return templateId;
	}

	/**
	 * @param templateId the templateId to set
	 */
	public void setTemplateId(int templateId) {
		this.templateId = templateId;
	}


	/**
	 * @return the templateName
	 */
	public String getTemplateName() {
		return templateName;
	}

	/**
	 * @param templateName the templateName to set
	 */
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	/**
	 * @return the columnTemplates
	 */
	public List<ColumnTemplate> getColumnTemplates() {
		return columnTemplates;
	}

	/**
	 * @param columnTemplates the columnTemplates to set
	 */
	public void setColumnTemplates(List<ColumnTemplate> columnTemplates) {
		this.columnTemplates = columnTemplates;
	}
	
	/**
	 * @return the headerRowsSize
	 */
	public int getHeaderRowsSize() {
		return headerRowsSize;
	}

	/**
	 * @param headerRowsSize the headerRowsSize to set
	 */
	public void setHeaderRowsSize(int headerRowsSize) {
		this.headerRowsSize = headerRowsSize;
	}

	/**
	 * @return the columnTemplatesMap
	 */
	public Map<Integer, ColumnTemplate> getColumnTemplatesMap() {
		initColumnTemplatesMap();
		return columnTemplatesMap;
	}

	/**
	 * @param columnTemplatesMap the columnTemplatesMap to set
	 */
	public void setColumnTemplatesMap(Map<Integer, ColumnTemplate> columnTemplatesMap) {
		this.columnTemplatesMap = columnTemplatesMap;
	}

	/**
	 * @param tempalteName the tempalteName to set
	 */
	public void setTempalteName(String tempalteName) {
		this.templateName = tempalteName;
	}

	/**
	 * @return the validatorClass
	 */
	public String getValidatorClass() {
		return validatorClass;
	}

	/**
	 * @param validatorClass the validatorClass to set
	 */
	public void setValidatorClass(String validatorClass) {
		this.validatorClass = validatorClass;
	}


	/**
	 * @return the templateClass
	 */
	public String getTemplateClass() {
		return templateClass;
	}

	/**
	 * @param templateClass the templateClass to set
	 */
	public void setTemplateClass(String templateClass) {
		this.templateClass = templateClass;
	}

	/**
	 * @return the processRowsPerThread
	 */
	public int getProcessRowsPerThread() {
		return processRowsPerThread;
	}

	/**
	 * @param processRowsPerThread the processRowsPerThread to set
	 */
	public void setProcessRowsPerThread(int processRowsPerThread) {
		this.processRowsPerThread = processRowsPerThread;
	}

	public ColumnTemplate getColumnTemplateByPos(int pos){
		initColumnTemplatesMap();
		return columnTemplatesMap.get(pos);
	}
	private void initColumnTemplatesMap(){
		if(columnTemplatesMap==null && columnTemplates.size()>0){
			columnTemplatesMap = new TreeMap<Integer, ColumnTemplate>();
			for(ColumnTemplate columnTemplate : columnTemplates){
				columnTemplatesMap.put(columnTemplate.getPos(), columnTemplate);
			}
		}
	}
	

}
