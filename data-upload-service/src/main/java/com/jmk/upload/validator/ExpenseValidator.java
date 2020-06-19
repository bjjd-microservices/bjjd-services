package com.jmk.upload.validator;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.jmk.cache.ProjectCache;

public class ExpenseValidator extends LocalValidatorFactoryBean implements Validator{
	
	@Autowired
	private ProjectCache projectCache;

}
