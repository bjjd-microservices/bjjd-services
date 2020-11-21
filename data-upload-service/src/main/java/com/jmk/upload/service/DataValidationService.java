package com.jmk.upload.service;

import org.springframework.web.multipart.MultipartFile;

import com.jmk.upload.model.ValidationResult;

public interface DataValidationService {

	public ValidationResult validate(MultipartFile file);

}

