package com.jmk.upload.template;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SheetTemplate implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3436559113592808359L;

	private int templateId;
	
	private String templateName;
	
	private String validator;
	
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
	 * @return the validator
	 */
	public String getValidator() {
		return validator;
	}

	/**
	 * @param validator the validator to set
	 */
	public void setValidator(String validator) {
		this.validator = validator;
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
