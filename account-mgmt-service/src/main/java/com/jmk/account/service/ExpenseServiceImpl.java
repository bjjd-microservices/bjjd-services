package com.jmk.account.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

	/* (non-Javadoc)
	 * @see com.jmk.account.service.ExpenseService#saveExpenses(java.util.List)
	 */
	@Override
	public List<Expense> saveExpenses(List<Expense> expenseModels) {
		List<com.jmk.account.entity.Expense> expenseEntities=expenseModels.stream().map(expenseModel->mapper.map(expenseModel, com.jmk.account.entity.Expense.class)).collect(Collectors.toList());
		Iterable<com.jmk.account.entity.Expense> iterableExpenses=repository.saveAll(expenseEntities);
		expenseModels=StreamSupport.stream(iterableExpenses.spliterator(),false).map(expenseEntity->mapper.map(expenseEntity, Expense.class)).collect(Collectors.toList());
		return expenseModels;
	}

	
}
