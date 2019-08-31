package com.demo.mortgage.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Customer {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "cust_id")    
    private Long id;
	
	@Column(name = "cust_first_name" )
    private String firstName;
	
	@Column(name = "cust_last_name" )
    private String lastName;
	
	@Column(name = "cust_gender")
    private String gender;
	
	@Column(name = "cust_pan" )
	@NotNull(message = "Pan details is mandatory")
    private String panDetail;
	
	@Column(name = "cust_phone" )	
    private String phoneNo;
	
	@Column(name = "cust_email")
    private String email;
		
	@Column(name = "cust_dob" )
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
	
    @Column(name = "cust_salary")
    private Double salary;
    
    @OneToOne(cascade =  CascadeType.ALL,mappedBy = "customer")
    private CustomerPropertyDetails customerPropertyDetails;
    
    @OneToOne(cascade =  CascadeType.ALL,mappedBy = "customer")
    private CustomerLoanDetails customerLoanDetails;


	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", panDetail=" + panDetail + ", phoneNo=" + phoneNo + ", email=" + email +
				", dateOfBirth=" + dateOfBirth
				+ ", salary=" + salary + "]";
	}

	
    
}
