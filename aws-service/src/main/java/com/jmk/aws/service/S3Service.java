package com.jmk.aws.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.model.PutObjectResult;

public interface S3Service {
	public PutObjectResult uploadFile(String category, String id, String filename, MultipartFile multipartFile);
	
	public List<PutObjectResult> uploadFile(MultipartFile[] multipartFiles);
	
	public ResponseEntity<byte[]> download(String key) throws IOException;
}

