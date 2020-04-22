package com.jmk.account.api;

import java.math.BigDecimal;
import java.time.LocalDate;

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
import com.jmk.account.enums.DonorType;
import com.jmk.account.enums.PaymentMode;
import com.jmk.account.model.Donation;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class DonationApiTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;
	
	private Donation donation;
	
	@Before
	public void setUp() {
		donation=new Donation();
		donation.amount(BigDecimal.valueOf(11111));
		donation.setPaymentMode(PaymentMode.CHEQUE);
		donation.setDonationDate(LocalDate.now());
		donation.setDonorId(22L);
		donation.setDonorType(DonorType.DEVOTEE);
		donation.setDonorMobileNo("9999779379");
		donation.setProjectId(1L);
		donation.setDonorName("NayakJi");
		donation.setProjectName("DarbarConstruction");
	}

	@Test
	public void testSaveDonation() {
		
		String jsonDonation=null;
		try {
			jsonDonation=objectMapper.writeValueAsString(donation);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		try {
			MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:7379/donation").accept(MediaType.APPLICATION_JSON_VALUE).contentType(MediaType.APPLICATION_JSON_VALUE).content(jsonDonation)).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
			donation=objectMapper.readValue(mvcResult.getResponse().getContentAsByteArray(), Donation.class);
			Assert.assertNotNull(donation);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
