package com.demo.mortgage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.mortgage.entity.LoanOffer;

public interface LoanOfferRepository extends JpaRepository<LoanOffer, Long> {

	public List<LoanOffer> findByAmountLessThanAndEmiLessThan(Long amount,Double emi);
}
