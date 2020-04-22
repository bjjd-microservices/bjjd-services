package com.jmk.account.util;

import org.springframework.http.ResponseEntity;

import com.jmk.account.feign.client.ProjectMgmtServiceClient;
import com.jmk.project.model.Project;

public interface RequestValidator<T> {
	
	public boolean validate(T t);
	
	public ProjectMgmtServiceClient getProjectMgmtServiceClient();
	
	public default boolean validProject(Long projectId) {
		ResponseEntity<Project> responseEntity = getProjectMgmtServiceClient()
				.findProjectDetailsById(projectId);
		return responseEntity.getBody() != null;
	}
	
}
