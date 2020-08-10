package com.jmk.upload.model;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.validation.Validator;

import com.jmk.upload.template.ExcelSheetTemplate;

public class ExcelFile implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9373417416953275L;

	private Sheet sheet;
	
	private boolean hasHeader;
	
	int rowsPerThread=100;
	
	private ExcelSheetTemplate fileTemplate;
	
	private Class<? extends Base> clazz;
	
	private Map<Integer, Limit> sheetThreads;
	
	private Validator validator;
	
	private int headerRowsSize;
	

	/**
	 * @param sheet
	 * @param hasHeader
	 * @param rowsPerThread
	 * @param fileTemplate
	 * @param clazz
	 * @param sheetThreads
	 * @param validator
	 */
	public ExcelFile(Sheet sheet, boolean hasHeader,int headerRowsSize, int rowsPerThread, ExcelSheetTemplate fileTemplate,
			Class<? extends Base> clazz, Validator validator) {
		super();
		this.sheet = sheet;
		this.hasHeader = hasHeader;
		this.headerRowsSize=headerRowsSize;
		this.rowsPerThread = rowsPerThread;
		this.fileTemplate = fileTemplate;
		this.clazz = clazz;
		this.validator = validator;
		prepareThreads();
	}
	
	



	/**
	 * @return the validator
	 */
	public Validator getValidator() {
		return validator;
	}





	/**
	 * @param validator the validator to set
	 */
	public void setValidator(Validator validator) {
		this.validator = validator;
	}





	/**
	 * @return the sheetThreads
	 */
	public Map<Integer, Limit> getSheetThreads() {
		return sheetThreads;
	}



	/**
	 * @param sheetThreads the sheetThreads to set
	 */
	public void setSheetThreads(Map<Integer, Limit> sheetThreads) {
		this.sheetThreads = sheetThreads;
	}



	/**
	 * @return the sheet
	 */
	public Sheet getSheet() {
		return sheet;
	}

	/**
	 * @param sheet the sheet to set
	 */
	public void setSheet(Sheet sheet) {
		this.sheet = sheet;
	}

	/**
	 * @return the hasHeader
	 */
	public boolean isHasHeader() {
		return hasHeader;
	}

	/**
	 * @param hasHeader the hasHeader to set
	 */
	public void setHasHeader(boolean hasHeader) {
		this.hasHeader = hasHeader;
	}

	/**
	 * @return the rowsPerThread
	 */
	public int getRowsPerThread() {
		return rowsPerThread;
	}

	/**
	 * @param rowsPerThread the rowsPerThread to set
	 */
	public void setRowsPerThread(int rowsPerThread) {
		this.rowsPerThread = rowsPerThread;
	}

	/**
	 * @return the fileTemplate
	 */
	public ExcelSheetTemplate getFileTemplate() {
		return fileTemplate;
	}

	/**
	 * @param fileTemplate the fileTemplate to set
	 */
	public void setFileTemplate(ExcelSheetTemplate fileTemplate) {
		this.fileTemplate = fileTemplate;
	}

	/**
	 * @return the clazz
	 */
	public Class<? extends Base> getClazz() {
		return clazz;
	}

	/**
	 * @param clazz the clazz to set
	 */
	public void setClazz(Class<? extends Base> clazz) {
		this.clazz = clazz;
	}
	
	public int getNoOfthreadsToProcess(){
		if(sheet.getLastRowNum()%rowsPerThread > 0 )
			return (sheet.getLastRowNum()/rowsPerThread)+1;
		else
			return (sheet.getLastRowNum()/rowsPerThread);
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





	private void prepareThreads() {
		sheetThreads=new TreeMap<>();
		int startRow;
		int endRow;
		int lastRow=sheet.getLastRowNum();
		for(int i=1;i<=getNoOfthreadsToProcess();i++) {
			startRow=i*rowsPerThread-rowsPerThread;
			endRow=i*rowsPerThread>lastRow?lastRow:i*rowsPerThread-1;
			Limit limit=new Limit(startRow, endRow);
			sheetThreads.put(i,limit);
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ExcelFile [sheet=" + sheet + ", hasHeader=" + hasHeader + ", rowsPerThread=" + rowsPerThread
				+ ", fileTemplate=" + fileTemplate + ", clazz=" + clazz + ", sheetThreads=" + sheetThreads + "]";
	}
	
	
	
	
	
}
