package com.jmk.upload.feign.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jmk.account.model.Donation;
import com.jmk.account.model.Expense;

@FeignClient(name="account-mgmt-service")
public interface AccountMgmtServiceClient {
	
	@PostMapping(value="/api/account-mgmt-service/donation/saveDonations",produces="application/json",consumes="application/json")
	ResponseEntity<List<Donation>> saveDonations(@RequestBody List<Donation> donations);
	
	@PostMapping(value="/api/account-mgmt-service/expense/saveExpenses",produces="application/json",consumes="application/json")
	ResponseEntity<List<Expense>> saveExpenses(@RequestBody List<Expense> expenses);

	   
}

