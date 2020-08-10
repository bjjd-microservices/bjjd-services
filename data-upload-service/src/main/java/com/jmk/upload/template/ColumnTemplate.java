package com.jmk.upload.template;

import java.io.Serializable;

public class ColumnTemplate  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1342747022085078517L;
	
	private int id;
	
	private int pos;
	
	private String sheetColumnName;
	
	private String beanPropertyName;
	
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

	/**
	 * @return the sheetColumnName
	 */
	public String getSheetColumnName() {
		return sheetColumnName;
	}

	/**
	 * @param sheetColumnName the sheetColumnName to set
	 */
	public void setSheetColumnName(String sheetColumnName) {
		this.sheetColumnName = sheetColumnName;
	}

	/**
	 * @return the beanPropertyName
	 */
	public String getBeanPropertyName() {
		return beanPropertyName;
	}

	/**
	 * @param beanPropertyName the beanPropertyName to set
	 */
	public void setBeanPropertyName(String beanPropertyName) {
		this.beanPropertyName = beanPropertyName;
	}
	
}
