package com.jmk.account.api;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jmk.account.enums.PaymentMode;
import com.jmk.account.model.Expense;
import com.jmk.enums.Group;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class ExpenseApiTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private Expense expense;
	
	@Before
	public void setUp() {
		expense=new Expense();
		expense.setVoucherNo(379L);
		expense.setExpenseDate(LocalDate.now());
		expense.setExpenseCategory("BuildingMaterials");
		expense.setExpenseItem("Bricks");
		expense.setProjectId(4L);
		expense.setProjectName("DarbarConstruction");
		expense.setAmount(BigDecimal.valueOf(379.00));
		expense.setPaymentMode(PaymentMode.CHEQUE);
		expense.setCreatedOn(LocalDateTime.now());
		expense.setGroupId(Group.BJJD.getGroupId());
		expense.setWhenModified(LocalDateTime.now());
	}
	
	@Test
	public void saveExpense() {
		String jsonExpense=null;
		try {
			jsonExpense=objectMapper.writeValueAsString(expense);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		try {
			MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:7379/expense/")
					.accept(MediaType.APPLICATION_JSON_VALUE).contentType(MediaType.APPLICATION_JSON_VALUE)
					.content(jsonExpense)).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
			expense=objectMapper.readValue(mvcResult.getResponse().getContentAsByteArray(), Expense.class);
			Assert.assertNotNull(expense);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
