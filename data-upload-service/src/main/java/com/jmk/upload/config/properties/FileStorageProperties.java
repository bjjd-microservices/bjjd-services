package com.jmk.upload.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="file")
public class FileStorageProperties {

	private String uploadDir;

	/**
	 * @return the uploadDir
	 */
	public String getUploadDir() {
		return uploadDir;
	}

	/**
	 * @param uploadDir the uploadDir to set
	 */
	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}
	
	
	
}
