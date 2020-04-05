package com.jmk.account.api;

import com.jmk.account.model.Expense;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-05T20:28:14.461+05:30")

@Controller
public class ExpenseApiController implements ExpenseApi {

    private static final Logger log = LoggerFactory.getLogger(ExpenseApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ExpenseApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Expense> saveExpense(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Expense body,@ApiParam(value = "" ) @RequestHeader(value="xChannel", required=false) String xChannel) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Expense>(objectMapper.readValue("{  \"paidTo\" : \"paidTo\",  \"amount\" : 6027456183070.4013671875,  \"groupId\" : 5,  \"approvedBy\" : 5,  \"description\" : \"description\",  \"id\" : 0,  \"projectName\" : \"projectName\",  \"projectId\" : 1,  \"remarks\" : \"remarks\",  \"expenseDate\" : \"2000-01-23\",  \"status\" : \"A\"}", Expense.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Expense>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<Expense>(objectMapper.readValue("<null>  <id>123456789</id>  <expenseDate>2000-01-23</expenseDate>  <description>aeiou</description>  <amount>1.3579</amount>  <projectId>123</projectId>  <projectName>aeiou</projectName>  <paidTo>aeiou</paidTo>  <remarks>aeiou</remarks>  <approvedBy>123456789</approvedBy>  <status>aeiou</status>  <groupId>123</groupId></null>", Expense.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<Expense>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Expense>(HttpStatus.NOT_IMPLEMENTED);
    }

}
