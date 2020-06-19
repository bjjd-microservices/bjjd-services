package com.jmk.upload.template;

import java.io.Serializable;

public class ColumnTemplate  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1342747022085078517L;
	
	private int id;
	
	private int pos;
	
	private String templateName;
	
	private String beanColumnName;
	
	private String type;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the pos
	 */
	public int getPos() {
		return pos;
	}

	/**
	 * @param pos the pos to set
	 */
	public void setPos(int pos) {
		this.pos = pos;
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
	 * @return the beanColumnName
	 */
	public String getBeanColumnName() {
		return beanColumnName;
	}

	/**
	 * @param beanColumnName the beanColumnName to set
	 */
	public void setBeanColumnName(String beanColumnName) {
		this.beanColumnName = beanColumnName;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
}
