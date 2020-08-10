package com.jmk.upload.service;

import java.util.List;
import java.util.Map;

import com.jmk.upload.model.Base;

public interface DataStorageService {

	public Map<String,List<? extends Object>> storeData(Map<String, List<? extends Base>> sheetMapping);
	
}
