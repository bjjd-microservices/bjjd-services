package com.jmk.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.jmk.project.entity.Project;

/**
 * Project
 */
public interface ProjectRepository  extends CrudRepository<Project,Long> {
	Project findByCode(String code);
}

