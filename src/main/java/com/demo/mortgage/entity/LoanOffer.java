package com.demo.mortgage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "loan_offer")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class LoanOffer {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "loan_offer_id")    
    private Long id;
	
	@Column(name = "loan_offer_amt" )
    private Long amount;
	
	@Column(name = "loan_offer_tenure" )
    private Integer tenure;
	
	@Column(name = "loan_offer_emi")
    private Double emi;
	
	@Column(name = "loan_offer_roi" )
    private Double rateOfInterest;

	@Override
	public String toString() {
		return "LoanOffer [id=" + id + ", amount=" + amount + ", tenure=" + tenure + ", emi=" + emi
				+ ", rateOfInterest=" + rateOfInterest + "]";
	}
	
	
}
