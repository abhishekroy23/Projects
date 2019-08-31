package com.demo.mortgage.service;

import java.util.List;

import com.demo.mortgage.entity.LoanOffer;

public interface LoanOfferService {

	public List<LoanOffer> getLoanOffersFromPropAmtAndEmi(Long amount,Double emi);
	public LoanOffer createLoanOffers(LoanOffer loanOffer);
}
