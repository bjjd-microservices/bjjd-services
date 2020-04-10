package com.jmk.account.service;

import java.util.List;

import com.jmk.account.model.Expense;

public interface ExpenseService {

	public Expense saveExpense(Expense expense);
	
	public List<Expense> saveExpenses(List<Expense> expenses);
}
