package com.jmk.upload.service;

import org.springframework.web.multipart.MultipartFile;

import com.jmk.upload.model.UploadFileResponse;

public interface DataStorageService {

	public UploadFileResponse storeData(MultipartFile file);
	
}
