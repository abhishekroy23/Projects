package com.demo.mortgage.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.mortgage.dto.CustomerDTO;
import com.demo.mortgage.dto.CustomerLoanOfferDTO;
import com.demo.mortgage.service.CustomerService;

@RestController
@RequestMapping(path="/customer") 
public class CustomerController {
	
	@Autowired 
	CustomerService customerService;

	@PostMapping
	public ResponseEntity<CustomerDTO> createUserAccount(@RequestBody CustomerDTO customer){
		
		customer = customerService.createCustomer(customer);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
	
	@PostMapping("/checkloaneligibity")
	public ResponseEntity<CustomerLoanOfferDTO> checkLoanEligibility(@Valid @RequestBody CustomerDTO customer){
		
		CustomerLoanOfferDTO customerLoanOfferDTO = customerService.checkAndGetLoanOptions(customer);
		return new ResponseEntity<>(customerLoanOfferDTO, HttpStatus.OK);
	}
}
