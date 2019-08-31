package com.demo.mortgage.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mortgage.dto.CustomerLoanDetailsRequestDTO;
import com.demo.mortgage.dto.CustomerLoanSummaryDTO;
import com.demo.mortgage.entity.Customer;
import com.demo.mortgage.entity.CustomerLoanDetails;
import com.demo.mortgage.exception.CustomerNotFound;
import com.demo.mortgage.mapper.TypeConverter;
import com.demo.mortgage.repository.CustomerLoanDetailsRepository;
import com.demo.mortgage.service.CustomerLoanDetailsService;
import com.demo.mortgage.service.CustomerService;

@Service
public class CustomerLoanDetailsServiceImpl implements CustomerLoanDetailsService{
	
	@Autowired
	TypeConverter typeConverter;
	@Autowired
	CustomerLoanDetailsRepository customerLoanDetailsRepository;
	@Autowired
	CustomerService customerService;

	@Override
	public CustomerLoanDetailsRequestDTO createCustomerLoanDetails(CustomerLoanDetailsRequestDTO customerLoanDetailsDTO) {
		CustomerLoanDetails customerLoanDetails = typeConverter.convertToCustLoanDetailsEntityFromDTO(customerLoanDetailsDTO);
		customerLoanDetailsRepository.save(customerLoanDetails);
		return customerLoanDetailsDTO;
	}

	@Override
	public CustomerLoanSummaryDTO getCustomerLoanDetails(String phoneNo,String emailId) {
		Optional<Customer> optCustomer = customerService.getCustomerByPhoneAndEmail(phoneNo, emailId);
		if(optCustomer.isPresent()) {
			return typeConverter.converToCustLoanSummaryFromCustomer(optCustomer.get());
		}else {
			throw new CustomerNotFound();
		}
	}

}
