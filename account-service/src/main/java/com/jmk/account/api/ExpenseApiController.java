package com.jmk.account.api;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jmk.account.feign.client.MessageSenderServiceClient;
import com.jmk.account.model.Donation;
import com.jmk.account.model.Expense;
import com.jmk.account.service.ExpenseService;
import com.jmk.account.util.RequestValidator;
import com.jmk.cache.UserCache;
import com.jmk.messaging.util.MessageBuilder;
import com.jmk.user.model.User;

import io.swagger.annotations.ApiParam;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-05T20:28:14.461+05:30")
@RestController
public class ExpenseApiController implements ExpenseApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExpenseApiController.class);

    private final HttpServletRequest request;
    
    @Autowired
    private ExpenseService expenseService;
    
    @Autowired
	private MessageSenderServiceClient messageSenderService;
    
    @Resource(name="expenseRequestValidator")
    private RequestValidator<Expense> validator;
    
    @Autowired
	private UserCache userCache;
	

    @org.springframework.beans.factory.annotation.Autowired
    public ExpenseApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.request = request;
    }

	public ResponseEntity<Expense> saveExpense(
			@ApiParam(value = "", required = true) @Valid @RequestBody Expense expense,
			@ApiParam(value = "") @RequestHeader(value = "xChannel", required = false) String xChannel) {
		String accept = request.getHeader("Accept");
		String username=request.getHeader("username");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml")
				|| accept.contains("*")) {
			if (validator.validate(expense)) {
				if(StringUtils.isNotBlank(username)) {
					enrichCommonDetails(expense,userCache.getUserByUsername(username));
				}
				expense = expenseService.saveExpense(expense);
				messageSenderService.sendMessage(MessageBuilder.build(expense));
				return new ResponseEntity<Expense>(expense, HttpStatus.OK);
			}
		}
		return new ResponseEntity<Expense>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

    public ResponseEntity<List<Expense>> saveExpenses(@ApiParam(value = "" ,required=true )  @Valid @RequestBody List<Expense> expenses,@ApiParam(value = "" ) @RequestHeader(value="xChannel", required=false) String xChannel) {
    	String accept = request.getHeader("Accept");
    	String username=request.getHeader("username");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml")
				|| accept.contains("*")) {
			if (StringUtils.isNotBlank(username)) {
				final User user = userCache.getUserByUsername(username);
				expenses = expenses.stream().map(expense -> enrichCommonDetails(expense, user))
						.collect(Collectors.toList());
			}
			expenses = expenseService.saveExpenses(expenses);
			messageSenderService.sendMessages(expenses.stream().map(expense->MessageBuilder.build(expense)).collect(Collectors.toList()));
			return new ResponseEntity<List<Expense>>(expenses,HttpStatus.OK);
		}
        return new ResponseEntity<List<Expense>>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    public ResponseEntity<Void> deleteExpenseById(
			@ApiParam(value = "Expense Id", required = true) @PathVariable("id") Long id) {
    	expenseService.deleteExpenseById(id);
        //Below return statement is the correct way to handle the delete request
        return ResponseEntity.noContent().build();
	}

	public ResponseEntity<Expense> findExpenseDetailsById(
			@ApiParam(value = "Expense Id", required = true) @PathVariable("id") Long id) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml") || accept.contains("*")) {
			Expense expense = expenseService.findExpenseDetailsById(id);
			return new ResponseEntity<Expense>(expense, HttpStatus.OK);
		}
		return new ResponseEntity<Expense>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	public ResponseEntity<Expense> updateExpenseById(
			@ApiParam(value = "Expense Id", required = true) @PathVariable("id") Long id,
			@ApiParam(value = "", required = true) @Valid @RequestBody Expense expense) {
		String accept = request.getHeader("Accept");
		String username=request.getHeader("username");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml")
				|| accept.contains("*")) {
			if(StringUtils.isNotBlank(username)) {
				enrichCommonDetails(expense,userCache.getUserByUsername(username));
			}
			expense = expenseService.saveExpense(expense);
			return new ResponseEntity<Expense>(expense, HttpStatus.OK);
		}

		return new ResponseEntity<Expense>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	private Expense enrichCommonDetails(Expense expense,User user) {
		if (expense.getId() == null) {
			expense.setCreatedOn(LocalDateTime.now());
			expense.setCreatedBy(user.getId());
			expense.setGroupId(user.getGroupId());
		}
		expense.setWhenModified(LocalDateTime.now());
		expense.setModifiedBy(user.getId());
		return expense;
	}
}