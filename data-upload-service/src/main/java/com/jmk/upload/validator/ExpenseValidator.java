package com.jmk.upload.validator;


import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.jmk.cache.ProjectCache;
import com.jmk.enums.Status;
import com.jmk.project.model.Project;
import com.jmk.upload.model.Expense;

@Component
public class ExpenseValidator extends LocalValidatorFactoryBean implements Validator{
	
	@Autowired
	private ProjectCache projectCache;

	@Override
	public boolean supports(Class<?> clazz) {
		return Expense.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Expense expense = (Expense) target;
		
		//Project Code should not be blank
		if(StringUtils.isBlank(expense.getProjectCode())) {
			errors.rejectValue("projectCode","project.code.required","Project code is required");
		}else {
			Project project=projectCache.getProjectByCode(expense.getProjectCode());
			if(project==null) {
				errors.rejectValue("projectCode","project.code.notExist","Project Code does not exist.");
			}else if(project.getStatus()!=Status.A){
				errors.rejectValue("projectCode","project.code.notActive","Project Code is not active.");
			}else {
				enrichExpenseWithProjectDetails(expense,project);
			}
		}
		
		if(expense.getAmount().doubleValue()<=0) {
			errors.rejectValue("expenseAmount","expense.amount.invalid","Expense Amount is invalid");
		}
		
	}
	
	
	
	private void enrichExpenseWithProjectDetails(Expense expense,Project project) {
		expense.setProjectId(project.getId());
		expense.setProjectName(project.getName());
	}

}

