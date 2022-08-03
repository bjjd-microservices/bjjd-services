package com.jmk.account.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jmk.project.model.Project;

@FeignClient(name="project-service")
public interface ProjectMgmtServiceClient {

	@GetMapping(value="/api/project-service/project/{id}",produces="application/json",consumes="application/json")
	ResponseEntity<Project> findProjectDetailsById(@PathVariable("id") Long id);		
	
}

