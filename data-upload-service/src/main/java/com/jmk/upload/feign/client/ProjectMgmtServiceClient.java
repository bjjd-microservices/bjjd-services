package com.jmk.upload.feign.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.jmk.project.model.Project;

@FeignClient(name="project-service")
public interface ProjectMgmtServiceClient {

	@PostMapping(value="/api/project-service/project/createProjects",produces="application/json",consumes="application/json")
	ResponseEntity<List<Project>> createProjects(@RequestBody List<Project> projects);
	
	@GetMapping(value="/api/project-service/project/findProjectByCode",produces="application/json",consumes="application/json")
	ResponseEntity<Project> findProjectByCode(@RequestParam("code") String code);
	
}



