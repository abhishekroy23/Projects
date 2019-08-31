package com.demo.mortgage.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.demo.mortgage.dto.CustomerDTO;
import com.demo.mortgage.dto.CustomerLoanOfferDTO;
import com.demo.mortgage.entity.Customer;
import com.demo.mortgage.entity.LoanOffer;
import com.demo.mortgage.exception.LoanOfferNotFound;
import com.demo.mortgage.mapper.TypeConverter;
import com.demo.mortgage.repository.CustomerRepository;
import com.demo.mortgage.service.CustomerService;
import com.demo.mortgage.service.LoanOfferService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CustomerRepository customerRespository;
	@Autowired
	TypeConverter typeConverter;
	@Autowired
	LoanOfferService loanOfferService;
	
	@Override
	public CustomerDTO createCustomer(CustomerDTO customerDTO) {
		Customer customer = typeConverter.convertToCustomerFromDTO(customerDTO);
		customerRespository.save(customer);
		return customerDTO;
	}

	@Override
	public CustomerLoanOfferDTO checkAndGetLoanOptions(CustomerDTO customerDTO) {
		Long maxLoanAmount = Math.round(customerDTO.getCustomerPropertyDetails().getPropValue()*0.8);
		List<LoanOffer> lstLoanOffers = loanOfferService
				.getLoanOffersFromPropAmtAndEmi(maxLoanAmount, customerDTO.getSalary());
		
		if(!CollectionUtils.isEmpty(lstLoanOffers)) {
			Customer customer = typeConverter.convertToCustomerFromDTO(customerDTO);
			customer = customerRespository.save(customer);
			return typeConverter.convertToCustLoanOffer(customer,lstLoanOffers);
		}else {
			logger.info("No loan offers found");
			throw new LoanOfferNotFound();
		}
	}

	@Override
	public Optional<Customer> getCustomerByID(Long customerId) {		
		return customerRespository.findById(customerId);
	}

	@Override
	public Optional<Customer> getCustomerByPhoneAndEmail(String phoneNo, String emailId) {
		return customerRespository.findByPhoneNoAndEmail(phoneNo, emailId);
	}

}
