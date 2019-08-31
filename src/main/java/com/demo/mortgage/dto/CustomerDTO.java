package com.demo.mortgage.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.demo.mortgage.validator.ValidAge;

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
public class CustomerDTO {

	private Long id;
	@NotNull(message = "FIRST_NAME_MANDATORY")
	private String firstName;
	
	@NotNull(message = "LAST_NAME_MANDATORY")
	private String lastName;
	
	private String gender;
	
	@NotNull(message = "PAN_MANDATORY")
	private String panDetail;
	@NotNull(message = "PHONE_MANDATORY")
	private String phoneNo;
	@NotNull(message = "EMAIL_MANDATORY")
	private String email;
	@NotNull(message = "DOB_MANDATORY")
	@ValidAge(message = "AGE_VALIDATION")
	private Date dateOfBirth;	
	@NotNull(message = "SALARY_MANDATORY")
	private Double salary;
	
	private CustomerPropertyDetailsDTO customerPropertyDetails;
	
}
