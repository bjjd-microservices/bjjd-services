package com.jmk.upload.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.jmk.cache.ProjectCache;
import com.jmk.upload.model.Project;

@Component
public class ProjectValidator extends LocalValidatorFactoryBean implements Validator {

	@Autowired
	private ProjectCache projectCache;

	@Override
	public boolean supports(Class<?> clazz) {
		return Project.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Project project = (Project) target;

		// Project Name is Required value
		if (StringUtils.isEmpty(project.getName())) {
			errors.rejectValue("name", "project.name.required", "Project Name is Required");
		}
		if (!StringUtils.isEmpty(project.getCode())) {
			com.jmk.project.model.Project projectModel = projectCache.getProjectByCode(project.getCode());
			if (projectModel != null) {
				errors.rejectValue("code", "project.code.exists", "Project Code already exists");
			}
		}

	}
}

