package com.jmk.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.jmk.project.entity.Project;

/**
 * Project
 */
public interface ProjectRepository extends CrudRepository<Project, Long> {
	Project findByCode(String code);

	// A derived delete query must start with deleteBy, followed by the name of the
	// selection criteria
	int deleteByCode(String code);
}
