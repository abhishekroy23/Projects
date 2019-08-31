package com.demo.mortgage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customer_property_details")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class CustomerPropertyDetails {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "cust_prop_id")    
    private Long id;
	
	@Column(name = "cust_prop_type")
    private String propType;
	
	@Column(name = "cust_prop_address")
    private String propAddress;
	
	@Column(name = "cust_prop_value")
    private Long propValue;
	
	@OneToOne( optional = false)
    @JoinColumn(name = "cust_id", nullable = false)
    private Customer customer;

	

	@Override
	public String toString() {
		return "CustomerPropertyDetails [id=" + id + ", propType=" + propType + ", propAddress=" + propAddress
				+ ", propValue=" + propValue +"]";
	}	
	
}
