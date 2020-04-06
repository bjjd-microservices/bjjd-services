package com.jmk.account.repository;

import org.springframework.data.repository.CrudRepository;

import com.jmk.account.entity.Expense;


public interface ExpenseRepository extends CrudRepository<Expense,Long> {

}
