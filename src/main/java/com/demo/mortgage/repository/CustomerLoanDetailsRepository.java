package com.demo.mortgage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.mortgage.entity.CustomerLoanDetails;

public interface CustomerLoanDetailsRepository extends JpaRepository<CustomerLoanDetails, Long> {

}
