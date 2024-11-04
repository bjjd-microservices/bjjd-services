package com.jmk.account.api;

import java.net.URI;
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
import com.jmk.account.feign.client.UserMgmtServiceClient;
import com.jmk.account.model.Expense;
import com.jmk.account.service.ExpenseService;
import com.jmk.account.util.RequestValidator;
import com.jmk.messaging.util.MessageBuilder;
import com.jmk.user.model.User;

import io.swagger.annotations.ApiParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	private UserMgmtServiceClient userMgmtServiceClient;

    @org.springframework.beans.factory.annotation.Autowired
    public ExpenseApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.request = request;
    }

	public String checkHealth() {
		return "{healthy:true}";
	}

	public ResponseEntity<Expense> saveExpense(Expense expense,String xChannel) {
		String accept = request.getHeader("Accept");
		String username=request.getHeader("username");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml")
				|| accept.contains("*")) {
			if (validator.validate(expense)) {
				if(StringUtils.isNotBlank(username)) {
					User user=userMgmtServiceClient.findUserDetailsByUserName(username).getBody();
					enrichCommonDetails(expense,user);
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
				final User user=userMgmtServiceClient.findUserDetailsByUserName(username).getBody();
				expenses = expenses.stream().map(expense -> enrichCommonDetails(expense, user))
						.collect(Collectors.toList());
			}
			expenses = expenseService.saveExpenses(expenses);
			messageSenderService.sendMessages(expenses.stream().map(expense->MessageBuilder.build(expense)).collect(Collectors.toList()));
			return new ResponseEntity<List<Expense>>(expenses,HttpStatus.OK);
		}
        return new ResponseEntity<List<Expense>>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
	public ResponseEntity<Expense> findExpenseDetailsById(Long id) {
			Expense expense = expenseService.findExpenseDetailsById(id);
			return new ResponseEntity<Expense>(expense, HttpStatus.OK);
	}
	
	public ResponseEntity<Expense> updateExpense(Long id,Expense expense) {
		String accept = request.getHeader("Accept");
		String username=request.getHeader("username");
		if (accept != null && accept.contains("application/json") || accept.contains("application/xml")
				|| accept.contains("*")) {
			if(StringUtils.isNotBlank(username)) {
				User user=userMgmtServiceClient.findUserDetailsByUserName(username).getBody();
				enrichCommonDetails(expense,user);
			}
			expense = expenseService.updateExpense(id,expense);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(expense.getId())
					.toUri();

			return ResponseEntity.created(location)
					.build();
		}

		return new ResponseEntity<Expense>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ResponseEntity<Void> deleteExpenseById(Long id) {
		expenseService.deleteExpenseById(id);
		//Below return statement is the correct way to handle the delete request
		return ResponseEntity.noContent().build();
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