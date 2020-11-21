package com.jmk.upload.model;

import java.util.List;
import java.util.Map;

public class UploadFileResponse {
	private String fileName;
	private String fileDownloadUri;
	private String fileType;
	private long size;
	private Map<String,List<? extends Object>> resultSheetMapping;
	
	public UploadFileResponse(String fileName, String fileDownloadUri, String fileType, long size) {
		super();
		this.fileName = fileName;
		this.fileDownloadUri = fileDownloadUri;
		this.fileType = fileType;
		this.size = size;
	}

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileDownloadUri() {
		return fileDownloadUri;
	}
	public void setFileDownloadUri(String fileDownloadUri) {
		this.fileDownloadUri = fileDownloadUri;
	}

	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}

	public Map<String, List<? extends Object>> getResultSheetMapping() {
		return resultSheetMapping;
	}
	public void setResultSheetMapping(Map<String, List<? extends Object>> resultSheetMapping) {
		this.resultSheetMapping = resultSheetMapping;
	}

	@Override
	public String toString() {
		return "UploadFileResponse [fileName=" + fileName + ", fileDownloadUri=" + fileDownloadUri + ", fileType="
				+ fileType + ", size=" + size + ", resultSheetMapping=" + resultSheetMapping + "]";
	}
	
}

