package com.demo.mortgage.exception.handler;

public enum ExceptionMapperEnum {
	CONSTRAINT_VIOLATION("Constraint violation"),
	LOAN_OFFER_NOT_FOUND("There are no loan schemes available based on your property value and salary"),
	CUSTOMER_NOT_FOUND("Unable to fetch customer record with the provided phone number and email id. Please provide a valid value"),
	FIRST_NAME_MANDATORY("First name is a mandatory field. Please provide a valid input"),
	LAST_NAME_MANDATORY("Last name is a mandatory field. Please provide a valid input"),
	PAN_MANDATORY("Pan detail is a mandatory field. Please provide a valid input"),
	PHONE_MANDATORY("Phone number is a mandatory field. Please provide a valid input"),
	EMAIL_MANDATORY("Email id is a mandatory field. Please provide a valid input"),
	AGE_VALIDATION("Age should be between 20 to 60"),
	SALARY_MANDATORY("Salary is a mandatory field. Please provide a valid input"),
	PROPERTY_VALUE_MANDATORY("Property value is a mandatory field. Please provide a valid input"),
	DOB_MANDATORY("Date of birth value is a mandatory field. Please provide a valid input");
	
	private final String exceptionMessage;
	private ExceptionMapperEnum(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;		
	}
	public String getValue() {
		return this.exceptionMessage;
	}
}
