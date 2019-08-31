package com.demo.mortgage.service;

import java.util.Optional;

import com.demo.mortgage.dto.CustomerDTO;
import com.demo.mortgage.dto.CustomerLoanOfferDTO;
import com.demo.mortgage.entity.Customer;

public interface CustomerService {

	public CustomerDTO createCustomer(CustomerDTO customerDTO);
	
	public CustomerLoanOfferDTO checkAndGetLoanOptions(CustomerDTO customerDTO);
	
	Optional<Customer> getCustomerByID(Long customerId);
	
	Optional<Customer> getCustomerByPhoneAndEmail(String phoneNo,String emailId);
}
