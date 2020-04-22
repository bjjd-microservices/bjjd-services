package com.jmk.account.service;

import java.time.LocalDate;
import java.util.List;

import com.jmk.account.model.Expense;

public interface ExpenseService {

	public Expense saveExpense(Expense expense);
	
	public List<Expense> saveExpenses(List<Expense> expenses);
	
	public Expense findExpenseDetailsById(Long id);
	
	public void deleteExpenseById(Long id);
	
	public List<Expense> findExpenseDetailsByDateRange(LocalDate startDate,LocalDate endDate);
}
