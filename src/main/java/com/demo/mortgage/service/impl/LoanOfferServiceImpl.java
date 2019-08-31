package com.demo.mortgage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mortgage.entity.LoanOffer;
import com.demo.mortgage.repository.LoanOfferRepository;
import com.demo.mortgage.service.LoanOfferService;

@Service
public class LoanOfferServiceImpl implements LoanOfferService{

	@Autowired
	LoanOfferRepository loanOfferRepository;
	@Override
	public List<LoanOffer> getLoanOffersFromPropAmtAndEmi(Long amount,Double emi) {
		return loanOfferRepository.findByAmountLessThanAndEmiLessThan(amount,emi);
	}
	@Override
	public LoanOffer createLoanOffers(LoanOffer loanOffer) {		
		return loanOfferRepository.save(loanOffer);
	}
	
}
