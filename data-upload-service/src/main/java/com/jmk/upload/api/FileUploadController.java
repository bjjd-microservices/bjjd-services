package com.jmk.upload.api;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.jmk.eh.apierror.ApiError;
import com.jmk.eh.apierror.ExcelSheetValidationError;
import com.jmk.eh.exception.ExcelSheetValidationException;
import com.jmk.enums.Result;
import com.jmk.upload.model.UploadFileResponse;
import com.jmk.upload.model.ValidationResult;
import com.jmk.upload.service.DataPersistenceService;
import com.jmk.upload.service.DataValidationService;

@RestController
@RequestMapping(value="/upload")
public class FileUploadController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(FileUploadController.class);

	@Autowired
	private DataPersistenceService dataPersistenceService;
	
	@Autowired
	private DataValidationService dataValidationService;
	
	@PostMapping("/")
	public ResponseEntity<UploadFileResponse> upload(@RequestParam("file") MultipartFile file){
		UploadFileResponse uploadFileResponse=new UploadFileResponse(file.getOriginalFilename(), file.getName(), file.getContentType(), file.getSize());
		System.out.println("File name: "+file.getOriginalFilename());
		System.out.println("File type: "+file.getContentType());
		ValidationResult validationResult=dataValidationService.validate(file);
		if(Result.SUCCESS.equals(validationResult.getResult())) {
			LOGGER.info("Excel File Processing Results : "+validationResult.getSheetResultMapping());
			Map<String,List<? extends Object>> resultSheetMapping=dataPersistenceService.storeData(validationResult.getSheetResultMapping());
			uploadFileResponse.setResultSheetMapping(resultSheetMapping);
		}else if(Result.FAILURE.equals(validationResult.getResult())){
			ExcelSheetValidationError excelSheetValidationError=new ExcelSheetValidationError();
			ApiError apiError=new ApiError(HttpStatus.BAD_REQUEST);
			apiError.addSubError(excelSheetValidationError);
			LOGGER.error("Validation Errors in Excel Sheet: "+file.getOriginalFilename());
			apiError.setMessage("Validation Errors in Excel Sheet: "+file.getOriginalFilename());
			validationResult.getSheetResultMapping().entrySet().stream().forEach(entry->entry.getValue().stream().forEach(base->excelSheetValidationError.addSheetRowErrors(entry.getKey(), base.getExcelSheetRowErrors())));
			throw new ExcelSheetValidationException(apiError);
		}  
		return new ResponseEntity<UploadFileResponse>(uploadFileResponse,HttpStatus.OK);
	}
	
}

