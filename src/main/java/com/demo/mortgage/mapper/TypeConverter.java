package com.demo.mortgage.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.demo.mortgage.dto.CustomerDTO;
import com.demo.mortgage.dto.CustomerLoanDetailsRequestDTO;
import com.demo.mortgage.dto.CustomerLoanOfferDTO;
import com.demo.mortgage.dto.CustomerLoanSummaryDTO;
import com.demo.mortgage.dto.LoanOfferDTO;
import com.demo.mortgage.entity.Customer;
import com.demo.mortgage.entity.CustomerLoanDetails;
import com.demo.mortgage.entity.CustomerPropertyDetails;
import com.demo.mortgage.entity.LoanOffer;

@Component
public class TypeConverter {
	
	public Customer convertToCustomerFromDTO(CustomerDTO customerDTO) {
		
		Customer customer = new Customer();
		customer.setId(customerDTO.getId());
		customer.setFirstName(customerDTO.getFirstName());
		customer.setLastName(customerDTO.getLastName());
		customer.setGender(customerDTO.getGender());
		customer.setPanDetail(customerDTO.getPanDetail());
		customer.setPhoneNo(customerDTO.getPhoneNo());
		customer.setEmail(customerDTO.getEmail());
		customer.setDateOfBirth(customerDTO.getDateOfBirth());
		customer.setSalary(customerDTO.getSalary());
		
		CustomerPropertyDetails custProp = new CustomerPropertyDetails();
		custProp.setCustomer(customer);
		custProp.setId(customerDTO.getCustomerPropertyDetails().getId());
		custProp.setPropAddress(customerDTO.getCustomerPropertyDetails().getPropAddress());
		custProp.setPropType(customerDTO.getCustomerPropertyDetails().getPropType());
		custProp.setPropValue(customerDTO.getCustomerPropertyDetails().getPropValue());
		
		customer.setCustomerPropertyDetails(custProp);
		
		return customer;
	}
	
	public List<LoanOfferDTO> convertToLoanOfferDTOFromEntity(List<LoanOffer> lstLoanOffers){
		List<LoanOfferDTO> lstLoanOfferDTO = new ArrayList<>();
		if(!CollectionUtils.isEmpty(lstLoanOffers)) {
			lstLoanOffers.forEach(loanOffer ->{
				LoanOfferDTO loanOfferDTO = new LoanOfferDTO();
				loanOfferDTO.setAmount(loanOffer.getAmount());
				loanOfferDTO.setEmi(loanOffer.getEmi());
				loanOfferDTO.setId(loanOffer.getId());
				loanOfferDTO.setRateOfInterest(loanOffer.getRateOfInterest());
				loanOfferDTO.setTenure(loanOffer.getTenure());
				lstLoanOfferDTO.add(loanOfferDTO);
			});
		}
		return lstLoanOfferDTO;
	}
	
	public CustomerLoanDetails convertToCustLoanDetailsEntityFromDTO(CustomerLoanDetailsRequestDTO custLoanDetailsDTO) {
		CustomerLoanDetails customerLoanDetails = new CustomerLoanDetails();
		
		Customer customer = new Customer();
		customer.setId(custLoanDetailsDTO.getCustomerId());
		
		LoanOffer loanOffer = new LoanOffer();
		loanOffer.setId(custLoanDetailsDTO.getLoanOfferId());
		
		customerLoanDetails.setCustomer(customer);
		customerLoanDetails.setLoanOffer(loanOffer);
		
		return customerLoanDetails;
	}
	
	public CustomerLoanSummaryDTO converToCustLoanSummaryFromCustomer(Customer customer) {
		CustomerLoanSummaryDTO customerLoanSummaryDTO = new CustomerLoanSummaryDTO();
		customerLoanSummaryDTO.setCustId(customer.getId());
		if(StringUtils.isNotBlank(customer.getFirstName()) && StringUtils.isNotBlank(customer.getLastName())){
			customerLoanSummaryDTO.setCustomerName(customer.getFirstName()+" "+customer.getLastName());
		}else if(StringUtils.isNotBlank(customer.getFirstName())) {
			customerLoanSummaryDTO.setCustomerName(customer.getFirstName());
		}
		if(customer.getCustomerLoanDetails()!=null && customer.getCustomerLoanDetails().getLoanOffer()!=null) {
			customerLoanSummaryDTO.setEmi(customer.getCustomerLoanDetails().getLoanOffer().getEmi());
			customerLoanSummaryDTO.setLoanAmount(customer.getCustomerLoanDetails().getLoanOffer().getAmount());
			customerLoanSummaryDTO.setLoanOfferId(customer.getCustomerLoanDetails().getLoanOffer().getId());
			customerLoanSummaryDTO.setRateOfInterest(customer.getCustomerLoanDetails().getLoanOffer().getRateOfInterest());
			customerLoanSummaryDTO.setTenure(customer.getCustomerLoanDetails().getLoanOffer().getTenure());
		}
		
		return customerLoanSummaryDTO;
	}
	
	public CustomerLoanOfferDTO convertToCustLoanOffer(Customer customer,List<LoanOffer> lstLoanOffer) {
		CustomerLoanOfferDTO customerLoanOfferDTO = new CustomerLoanOfferDTO();
		customerLoanOfferDTO.setCustomerId(customer.getId());
		customerLoanOfferDTO.setCustomerEmail(customer.getEmail());
		if(StringUtils.isNotBlank(customer.getFirstName()) && StringUtils.isNotBlank(customer.getLastName())){
			customerLoanOfferDTO.setCustomerName(customer.getFirstName()+" "+customer.getLastName());
		}else if(StringUtils.isNotBlank(customer.getFirstName())) {
			customerLoanOfferDTO.setCustomerName(customer.getFirstName());
		}
		customerLoanOfferDTO.setCustomerPhone(customer.getPhoneNo());
		customerLoanOfferDTO.setLoanOptions(convertToLoanOfferDTOFromEntity(lstLoanOffer));
		return customerLoanOfferDTO;
	}
}
