package com.jmk.upload.template.handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jmk.upload.template.SheetTemplate;

@Component
public class SheetTemplateHandler {
	
	private Map<String,SheetTemplate> sheetTemplateMapping;
	
	public SheetTemplateHandler() {
		Resource resource=new ClassPathResource("templates/sheetTemplate.json");
		ObjectMapper objectMapper=new ObjectMapper();
		try {
			TypeReference<HashMap<String,SheetTemplate>> mapTypeRefernce=new TypeReference<HashMap<String,SheetTemplate>>(){};
			sheetTemplateMapping=(Map<String,SheetTemplate>)objectMapper.readValue(resource.getInputStream(),mapTypeRefernce);
			System.out.println(sheetTemplateMapping);
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @return the sheetTemplateMapping
	 */
	public Map<String, SheetTemplate> getSheetTemplateMapping() {
		return sheetTemplateMapping;
	}

}
