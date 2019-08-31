package com.demo.mortgage.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class CustomerLoanOfferDTO {

	private Long customerId;
	private String customerName;
	private String customerPhone;
	private String customerEmail;
	private List<LoanOfferDTO> loanOptions;
}
