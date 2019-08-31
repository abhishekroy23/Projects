package com.demo.mortgage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "customer_loan")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class CustomerLoanDetails {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "cust_loan_id")    
    private Long id;
	
	@OneToOne( optional = false)
    @JoinColumn(name = "cust_id", nullable = false)
    private Customer customer;
	
	@ManyToOne( optional = false)
    @JoinColumn(name = "loan_offer_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
    private LoanOffer loanOffer;
	
	
	
}
