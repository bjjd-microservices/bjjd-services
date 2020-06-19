package com.jmk.upload.service;

import java.util.List;
import java.util.Map;

import com.jmk.upload.model.Base;
import com.jmk.upload.model.UploadFileResponse;

public interface DataStorageService {

	public UploadFileResponse storeData(Map<String, List<? extends Base>> sheetMapping);
	
}
