package com.jmk.account.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jmk.account.model.Expense;
import com.jmk.account.service.ExpenseService;

import io.swagger.annotations.ApiParam;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-05T20:28:14.461+05:30")

@RestController
public class ExpenseApiController implements ExpenseApi {

    private static final Logger log = LoggerFactory.getLogger(ExpenseApiController.class);

    private final HttpServletRequest request;
    
    @Autowired
    private ExpenseService expenseService;

    @org.springframework.beans.factory.annotation.Autowired
    public ExpenseApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.request = request;
    }

    public ResponseEntity<Expense> saveExpense(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Expense expense,@ApiParam(value = "" ) @RequestHeader(value="xChannel", required=false) String xChannel) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml")
				|| accept.contains("*")) {
			expense = expenseService.saveExpense(expense);
			return new ResponseEntity<Expense>(expense, HttpStatus.OK);
		}

		return new ResponseEntity<Expense>(HttpStatus.INTERNAL_SERVER_ERROR);

	}

    public ResponseEntity<Void> saveExpenses(@ApiParam(value = "" ,required=true )  @Valid @RequestBody List<Expense> expenses,@ApiParam(value = "" ) @RequestHeader(value="xChannel", required=false) String xChannel) {
    	String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml")
				|| accept.contains("*")) {
			expenses = expenseService.saveExpenses(expenses);
			return new ResponseEntity<>(HttpStatus.OK);
		}
        return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
