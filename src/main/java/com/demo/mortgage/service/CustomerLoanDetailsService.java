package com.demo.mortgage.service;

import com.demo.mortgage.dto.CustomerLoanDetailsRequestDTO;
import com.demo.mortgage.dto.CustomerLoanSummaryDTO;

public interface CustomerLoanDetailsService {

	CustomerLoanDetailsRequestDTO createCustomerLoanDetails(CustomerLoanDetailsRequestDTO customerLoanDetailsDTO);
	CustomerLoanSummaryDTO getCustomerLoanDetails(String phoneNo,String emailId);
}
