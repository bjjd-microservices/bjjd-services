package com.jmk.account.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jmk.account.feign.client.ProjectMgmtServiceClient;
import com.jmk.account.model.Expense;

@Component("expenseRequestValidator")
public class ExpenseRequestValidator implements RequestValidator<Expense> {
	
	@Autowired
	private ProjectMgmtServiceClient projectMgmtServiceClient;

	public boolean validate(Expense expense) {
		 return validProject(expense.getProjectId());
	}

	@Override
	public ProjectMgmtServiceClient getProjectMgmtServiceClient() {
		return projectMgmtServiceClient;
	}
	
}

