package com.jmk.upload.model;

import java.io.Serializable;

public class Limit implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5551016671562093550L;
	
	int startRow;
	
	int endRow;

	/**
	 * @param startRow
	 * @param endRow
	 */
	public Limit(int startRow, int endRow) {
		super();
		this.startRow = startRow;
		this.endRow = endRow;
	}

	/**
	 * @return the startRow
	 */
	public int getStartRow() {
		return startRow;
	}

	/**
	 * @param startRow the startRow to set
	 */
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	/**
	 * @return the endRow
	 */
	public int getEndRow() {
		return endRow;
	}

	/**
	 * @param endRow the endRow to set
	 */
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Limit [startRow=" + startRow + ", endRow=" + endRow + "]";
	}
	
}
