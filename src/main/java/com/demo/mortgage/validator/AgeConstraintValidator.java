package com.demo.mortgage.validator;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeConstraintValidator implements ConstraintValidator<ValidAge,Date>{

	@Override
	public boolean isValid(Date dateOfBith, ConstraintValidatorContext cvc) {  
		if(dateOfBith!=null) {
			int age = calculateAge(dateOfBith);
			return (age>=20 && age<=60)?true:false;  
		}
		return false;		
	}  

	public int calculateAge(Date dateOfBith) {
		LocalDate localDob = dateOfBith.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate localCurrent = LocalDate.now(ZoneId.systemDefault());
		// validate inputs ...
		return Period.between(localDob, localCurrent).getYears();
	}
}


