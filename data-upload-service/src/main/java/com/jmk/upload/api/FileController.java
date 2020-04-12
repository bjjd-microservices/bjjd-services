package com.jmk.upload.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jmk.upload.model.UploadFileResponse;
import com.jmk.upload.service.DataStorageService;

@RestController
@RequestMapping(value="/upload")
public class FileController {

	@Autowired
	private DataStorageService storageService;
	
	@PostMapping("/")
	public ResponseEntity<UploadFileResponse> upload(@RequestParam("file") MultipartFile file){
		System.out.println("File name: "+file.getName());
		System.out.println("File type: "+file.getContentType());
		storageService.storeData(file);
		return new ResponseEntity<UploadFileResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
