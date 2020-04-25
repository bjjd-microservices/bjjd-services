package com.jmk.account.util;

import org.springframework.http.ResponseEntity;

import com.jmk.account.feign.client.ProjectMgmtServiceClient;
import com.jmk.eh.exception.StatusNotActiveException;
import com.jmk.enums.Status;
import com.jmk.project.model.Project;

public interface RequestValidator<T> {
	
	public boolean validate(T t);
	
	public ProjectMgmtServiceClient getProjectMgmtServiceClient();
	
	public default boolean validProject(Long projectId) {
		boolean isValid=false;
		ResponseEntity<Project> responseEntity = getProjectMgmtServiceClient()
				.findProjectDetailsById(projectId);
		Project project=responseEntity.getBody();
		if (Status.A.equals(project.getStatus())) {
			isValid = true;
		} else {
			throw new StatusNotActiveException(project.getClass(), "id", project.getId().toString());
		}
		return  isValid;
	}
	
}

