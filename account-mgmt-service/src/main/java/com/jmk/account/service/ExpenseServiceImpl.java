package com.jmk.account.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmk.account.model.Expense;
import com.jmk.account.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ExpenseRepository repository;
	
	@Override
	public Expense saveExpense(Expense expenseModel) {
		com.jmk.account.entity.Expense expenseEntity=mapper.map(expenseModel, com.jmk.account.entity.Expense.class);
		expenseEntity=repository.save(expenseEntity);
		expenseModel=mapper.map(expenseEntity, Expense.class);
		return expenseModel;
	}

}
