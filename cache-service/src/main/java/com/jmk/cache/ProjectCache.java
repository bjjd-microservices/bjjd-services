package com.jmk.cache;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.jmk.cache.feign.client.ProjectMgmtServiceClient;
import com.jmk.project.model.Project;

@Component
public class ProjectCache {

	@Autowired
	private ProjectMgmtServiceClient projectMgmtServiceClient;

	@Autowired
	private CacheManager cacheManager;

	private boolean isProjectCacheInitialized = false;

	@Cacheable(cacheNames = "projectCache", key = "#code",unless="#result == null")
	public Project getProjectByCode(String code) {
		/*
		 * if (!isProjectCacheInitialized) { initProjectCache(); }
		 */ 
		ResponseEntity<Project> responseEntity = projectMgmtServiceClient.findProjectByCode(code);
		Project project = responseEntity.getBody();
		return project;
	}

	/**
	 * This method can be used to load all the active projects in the cache
	 */
	private void initProjectCache() {
		if (!isProjectCacheInitialized) {
			Cache cache = cacheManager.getCache("projectCache");
			ResponseEntity<List<Project>> responseEntity = projectMgmtServiceClient.findProjectsByStatus("A");
			responseEntity.getBody().stream().forEach(project -> cache.put(project.getCode(), project));
			isProjectCacheInitialized = true;
		}
	}

}

