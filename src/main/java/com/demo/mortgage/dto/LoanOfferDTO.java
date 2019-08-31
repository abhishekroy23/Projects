package com.demo.mortgage.dto;

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
public class LoanOfferDTO {

	private Long id;
	
    private Long amount;
	
    private Integer tenure;
	
    private Double emi;
	
    private Double rateOfInterest;
}
