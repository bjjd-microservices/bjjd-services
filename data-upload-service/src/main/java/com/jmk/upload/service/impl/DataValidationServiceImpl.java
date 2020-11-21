package com.jmk.upload.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import com.jmk.enums.Result;
import com.jmk.upload.excel.processor.ExcelFileParallelProcessor;
import com.jmk.upload.model.Base;
import com.jmk.upload.model.ExcelFile;
import com.jmk.upload.model.ValidationResult;
import com.jmk.upload.service.DataValidationService;
import com.jmk.upload.template.ExcelSheetTemplate;
import com.jmk.upload.template.handler.ExcelSheetTemplateReader;

@Component
public class DataValidationServiceImpl implements DataValidationService {
	
	@Autowired
	private ExcelFileParallelProcessor excelFileParallelProcessor;
	
	@Autowired
	private ExcelSheetTemplateReader excelSheetTemplateReader;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@SuppressWarnings("unchecked")
	@Override
	public ValidationResult validate(MultipartFile file) {
		ValidationResult validationResult = null;
		Map<String, List<Base>> sheetResultMapping = new HashMap<>();
		Map<String, ExcelSheetTemplate> sheetTemplateMapping = excelSheetTemplateReader.getExcelSheetTemplateMapping();
		ExcelFile excelFile = null;
		try (Workbook workbook = file.getOriginalFilename().endsWith("xls") ? new HSSFWorkbook(file.getInputStream())
				: new XSSFWorkbook(file.getInputStream())) {
			Iterator<Sheet> sheetIterator = workbook.sheetIterator();
			while (sheetIterator.hasNext()) {
				Sheet sheet = sheetIterator.next();
				ExcelSheetTemplate excelSheetTemplate=sheetTemplateMapping.get(sheet.getSheetName());
					try {
						excelFile = new ExcelFile(sheet, true,excelSheetTemplate.getHeaderRowsSize(), excelSheetTemplate.getProcessRowsPerThread(), excelSheetTemplate, (Class<? extends Base>) Class.forName(excelSheetTemplate.getTemplateClass()),
								(Validator)getBean(Class.forName(excelSheetTemplate.getValidatorClass())));
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
					List<Base> objectList = excelFileParallelProcessor.readExcelinParallel(excelFile);
					sheetResultMapping.put(sheet.getSheetName(), objectList);
			}
			validationResult = processResult(sheetResultMapping);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return validationResult;
	}
	
	private ValidationResult processResult(Map<String, List<Base>> sheetResultMapping) {
		ValidationResult validationResult=new ValidationResult();
		
		// Below map contains the mapping of the all the sheet which contains no error in any row
		Map<String, List<? extends Base>> validatedSheetResultMapping = sheetResultMapping.entrySet().stream()
				.filter(entry -> entry.getValue().stream().allMatch(base -> !base.getErrors().hasErrors()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		
		// Below map contains the mapping of the all the sheet which contains error if in any row
		Map<String, List<? extends Base>> errorSheetResultMapping = sheetResultMapping.entrySet().stream()
				.filter(entry -> !validatedSheetResultMapping.keySet().contains(entry.getKey()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		
		// Below map contains the mapping of the all the sheet which contains only rows having error
		errorSheetResultMapping = errorSheetResultMapping.entrySet().stream().filter(entry -> !entry.getValue().isEmpty()).collect(Collectors.toMap(Map.Entry::getKey, i -> i
						.getValue().stream().filter(e -> e.getErrors().hasErrors()).collect(Collectors.toList())));
		if (errorSheetResultMapping.size() > 0) {
			validationResult.setResult(Result.FAILURE);
			validationResult.setSheetResultMapping(errorSheetResultMapping);
		}else {
			validationResult.setResult(Result.SUCCESS);
			validationResult.setSheetResultMapping(validatedSheetResultMapping);
		}
		return validationResult;

	}
	public <T extends Object> T getBean(Class<T> beanClass){
		return applicationContext.getBean(beanClass);
	}
}
