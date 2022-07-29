package com.jmk.project.service;

import java.util.List;

import com.jmk.enums.Status;
import com.jmk.project.model.Project;

public interface ProjectService   {

	Project saveProject(Project project);
	
	Project findProjectDetailsById(Long id);
	
	void deleteProjectById(Long id);
	
	List<Project> saveProjects(List<Project> project);

	List<Project> findAllProjectsByStatus(Status status);
	
	Project findProjectByCode(String code);
	
	int deleteProjectByProjectCode(String projectCode);

}

