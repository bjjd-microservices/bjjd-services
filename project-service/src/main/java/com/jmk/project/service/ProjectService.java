package com.jmk.project.service;

import java.util.List;

import com.jmk.enums.Status;
import com.jmk.project.model.Project;

public interface ProjectService   {

	Project saveProject(Project project);

	Project updateProject(Long id,Project project);
	
	Project findProjectById(Long id);
	
	void deleteProjectById(Long id);
	
	List<Project> saveProjects(List<Project> project);

	List<Project> findProjectsByStatus(Status status);

	List<Project> findAllProjects();
	
	Project findProjectByCode(String code);
	
	int deleteProjectByProjectCode(String projectCode);

}

