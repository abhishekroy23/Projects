package com.demo.mortgage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.mortgage.dto.CustomerLoanDetailsRequestDTO;
import com.demo.mortgage.dto.CustomerLoanSummaryDTO;
import com.demo.mortgage.service.CustomerLoanDetailsService;

@RestController
@RequestMapping(path="/customerloandetails") 
public class CustomerLoanDetailsController {

	@Autowired
	CustomerLoanDetailsService customerLoanDetailsService;
	
	@PostMapping
	public ResponseEntity<String> createCustomerLoanDetails(@RequestBody CustomerLoanDetailsRequestDTO customerLoanDetailsDTO){
		
		customerLoanDetailsService.createCustomerLoanDetails(customerLoanDetailsDTO);
		return new ResponseEntity<>("Loan applied successfully", HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<CustomerLoanSummaryDTO> getCustomerLoanDetails(@RequestParam String phoneNo,@RequestParam String emailId){		
		CustomerLoanSummaryDTO customerLoanSummaryDTO = customerLoanDetailsService.getCustomerLoanDetails(phoneNo, emailId);
		return new ResponseEntity<>(customerLoanSummaryDTO, HttpStatus.OK);
	}
}
