package com.demo.mortgage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.mortgage.entity.LoanOffer;
import com.demo.mortgage.service.LoanOfferService;

@RestController
@RequestMapping(path="/loanoffer") 
public class LoanOfferController {

	@Autowired
	LoanOfferService loanOfferService;
	
	@PostMapping
	public ResponseEntity<LoanOffer> createUserAccount(@RequestBody LoanOffer loanOffer){
		
		loanOffer = loanOfferService.createLoanOffers(loanOffer);
		return new ResponseEntity<LoanOffer>(loanOffer, HttpStatus.OK);
	}
}
