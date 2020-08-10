package com.jmk.upload.template.handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jmk.upload.template.ExcelSheetTemplate;

@Component
public class ExcelSheetTemplateHandler {
	
	private Map<String,ExcelSheetTemplate> excelSheetTemplateMapping;
	
	public ExcelSheetTemplateHandler() {
		Resource resource=new ClassPathResource("templates/excelSheetTemplate.json");
		ObjectMapper objectMapper=new ObjectMapper();
		try {
			TypeReference<HashMap<String,ExcelSheetTemplate>> mapTypeRefernce=new TypeReference<HashMap<String,ExcelSheetTemplate>>(){};
			excelSheetTemplateMapping=(Map<String,ExcelSheetTemplate>)objectMapper.readValue(resource.getInputStream(),mapTypeRefernce);
			System.out.println(excelSheetTemplateMapping);
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @return the sheetTemplateMapping
	 */
	public Map<String, ExcelSheetTemplate> getExcelSheetTemplateMapping() {
		return excelSheetTemplateMapping;
	}

}
