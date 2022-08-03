package com.jmk.cache.feign.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jmk.project.model.Project;

@FeignClient(name="project-service",contextId="project-cache-service")
public interface ProjectMgmtServiceClient {


	@GetMapping(value="/api/project-service/project/findByStatus",produces="application/json",consumes="application/json")
	ResponseEntity<List<Project>> findProjectsByStatus(@RequestParam("status") String status);	
	
	@GetMapping(value="/api/project-service/project/findProjectByCode",produces="application/json",consumes="application/json")
	ResponseEntity<Project> findProjectByCode(@RequestParam("code") String code);
	
}

