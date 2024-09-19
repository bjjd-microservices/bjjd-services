package com.jmk.project.repository;

import com.jmk.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.jmk.project.entity.Project;

/**
 * Project
 */
public interface ProjectRepository extends JpaRepository<Project, Long> {

	Iterable<Project> findByStatus(Status status);

	Project findByCode(String code);

	// A derived delete query must start with deleteBy, followed by the name of the
	// selection criteria
	int deleteByCode(String code);
}
