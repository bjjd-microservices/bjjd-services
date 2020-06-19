package com.jmk.upload.excel.processor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;

import com.jmk.enums.ExcelFileErrorType;
import com.jmk.enums.Status;
import com.jmk.upload.model.Base;
import com.jmk.upload.model.ExcelFile;
import com.jmk.upload.model.Limit;
import com.jmk.upload.template.ColumnTemplate;
import com.jmk.upload.template.SheetTemplate;

public final class ExcelFileReader {

	private final static Logger log = LoggerFactory.getLogger(ExcelFileParallelProcessor.class);

	private static final String VARCHAR = "VARCHAR";
	private static final String DECIMAL = "DECIMAL";
	private static final String TIMESTAMP = "TIMESTAMP";
	private static final String BOOLEAN = "BOOLEAN";
	private static final String DATE = "DATE";
	private static final String STATUS="STATUS";

	private ExcelFileReader() {

	}

	public static <T extends Base> List<T> readExcelFile(ExcelFile excelFile, Limit limit, boolean hasHeaderRow) {
		List<T> objectList = new ArrayList<>();
		BindException bindException;
		T object;
		ColumnTemplate columnTemplate;
		int startRow = limit.getStartRow();
		int endRow = limit.getEndRow();
		SheetTemplate fileTemplate = excelFile.getFileTemplate();
		try {
			// Sheet sheet = workbook.getSheetAt(0);
			if (limit.getStartRow() == -1 && limit.getEndRow() == -1) {
				startRow = excelFile.getSheet().getFirstRowNum();
				endRow = excelFile.getSheet().getLastRowNum();
			}

			for (int currRow = startRow; currRow <= endRow; currRow++) {
				object = (T) excelFile.getClazz().newInstance();

				Row row = (Row) excelFile.getSheet().getRow(currRow);
				bindException = new BindException(object, "" + row.getRowNum());

				if (hasHeaderRow && row.getRowNum() < 1) {
					continue;// just skip the row if row number 0 if header row is true
				}

				/*
				 * Dynamically calculate positions based on Column Name and Bean Name if needed
				 * to not use static pos from conf
				 */
				for (Integer pos : fileTemplate.getColumnTemplatesMap().keySet()) {
					columnTemplate = fileTemplate.getColumnTemplatesMap().get(pos);
					if (row.getCell(pos) != null) {
						switch (columnTemplate.getType()) {
						case DATE:
							BeanUtils.setProperty(object, columnTemplate.getBeanColumnName(),
									getDateCellValue(row.getCell(pos), bindException, columnTemplate));
							break;
						case BOOLEAN:
							BeanUtils.setProperty(object, columnTemplate.getBeanColumnName(),
									getBooleanCellValue(row.getCell(pos), bindException, columnTemplate));
							break;
						case DECIMAL:
							BeanUtils.setProperty(object, columnTemplate.getBeanColumnName(),
									getDecimalCellValue(row.getCell(pos), bindException, columnTemplate));
							break;
						case STATUS:
							BeanUtils.setProperty(object, columnTemplate.getBeanColumnName(),
									getStatusCellValue(row.getCell(pos), bindException, columnTemplate));
							break;
						default:
							BeanUtils.setProperty(object, columnTemplate.getBeanColumnName(),
									getStringCellValue(row.getCell(pos), bindException, columnTemplate));
						}
					}

				}
				object.setRow(row.getRowNum() + 1);

				if (excelFile.getValidator() != null) {
					excelFile.getValidator().validate(object, bindException);
				}
				object.setErrors(bindException);
				objectList.add(object);

			}
		} catch (Exception e) {
			log.error("File contain some invalid values" + e.getMessage());
			e.printStackTrace();
		}

		return objectList;
	}

	/**
	 * To get the date value
	 * 
	 * @param cell
	 * @param errors
	 * @param columnTemplate
	 * @return
	 */
	private static LocalDate getDateCellValue(Cell cell, Errors errors, ColumnTemplate columnTemplate) {
		LocalDate localDate = null;
		if (cell != null) {
			try {
				localDate = cell.getLocalDateTimeCellValue().toLocalDate();
			} catch (IllegalStateException | NumberFormatException e) {
				log.error(e.getMessage());
				errors.rejectValue(columnTemplate.getBeanColumnName(),
						ExcelFileErrorType.INVALID_DATE_VALUE.getErrorType(),new Object[] {cell}, cell.toString());
			}
		}
		return localDate;
	}

	/**
	 * Get the String value
	 * 
	 * @param cell
	 * @param errors
	 * @param columnTemplate
	 * @return
	 */
	private static String getStringCellValue(Cell cell, Errors errors, ColumnTemplate columnTemplate) {
		String rtrnVal = "";

		try {
			if (cell != null) {
				if (cell.getCellType() == CellType.NUMERIC) {
					rtrnVal = "" + cell.getNumericCellValue();
				} else if (cell.getCellType() == CellType.FORMULA) {
					rtrnVal = cell.getCellFormula();
				} else {
					rtrnVal = cell.getStringCellValue();
				}
			}
		} catch (Exception exception) {
			log.error(exception.getMessage());
			exception.printStackTrace();
			errors.rejectValue(columnTemplate.getBeanColumnName(),
					ExcelFileErrorType.INVALID_STRING_VALUE.getErrorType(), cell.toString());
		}
		return rtrnVal;
	}
	
	/**
	 * Get the String value
	 * 
	 * @param cell
	 * @param errors
	 * @param columnTemplate
	 * @return
	 */
	private static Status getStatusCellValue(Cell cell, Errors errors, ColumnTemplate columnTemplate) {
		Status rtrnVal = null;

		try {
			if (cell != null) {
				if (cell.getCellType() == CellType.STRING) {
					String cellValue = cell.getStringCellValue();
					rtrnVal=Status.fromValue(cellValue);
				} 
			}
		} catch (Exception exception) {
			log.error(exception.getMessage());
			exception.printStackTrace();
			errors.rejectValue(columnTemplate.getBeanColumnName(),
					ExcelFileErrorType.INVALID_STRING_VALUE.getErrorType(), cell.toString());
		}
		return rtrnVal;
	}


	/**
	 * Get the decimal value
	 * 
	 * @param cell
	 * @param errors
	 * @param columnTemplate
	 * @return
	 */
	private static BigDecimal getDecimalCellValue(Cell cell, Errors errors, ColumnTemplate columnTemplate) {
		BigDecimal rtrnVal = new BigDecimal(0);
		try {
			if (cell != null) {
				if (cell.toString().trim().length() == 0)
					return rtrnVal = new BigDecimal(0);
				else if (cell.getCellType() == CellType.NUMERIC) {
					rtrnVal = BigDecimal.valueOf(cell.getNumericCellValue());
					return rtrnVal = rtrnVal.setScale(3, BigDecimal.ROUND_CEILING).stripTrailingZeros();
				}
			}
		} catch (Exception exception) {
			log.error(exception.getMessage());
			errors.rejectValue(columnTemplate.getBeanColumnName(),
					ExcelFileErrorType.INVALID_DECIMAL_VALUE.getErrorType(), cell.toString());
		}

		return rtrnVal;
	}

	/**
	 * Get the boolean value
	 * 
	 * @param cell
	 * @param errors
	 * @param columnTemplate
	 * @return
	 */
	private static Boolean getBooleanCellValue(Cell cell, Errors errors, ColumnTemplate columnTemplate) {
		boolean rtrnVal = false;
		try {
			if (cell != null) {
				if (cell.toString().trim().length() == 0)
					return rtrnVal;
				else if (cell.getCellType() == CellType.BOOLEAN) {
					rtrnVal = cell.getBooleanCellValue();
					return rtrnVal;
				}
			}
		} catch (IllegalStateException exception) {
			log.error(exception.getMessage());
			errors.rejectValue(columnTemplate.getBeanColumnName(),
					ExcelFileErrorType.INVALID_DECIMAL_VALUE.getErrorType(), cell.toString());
		}

		return rtrnVal;
	}

}
