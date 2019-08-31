package com.demo.mortgage.exception.handler;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.demo.mortgage.dto.ErrorResponse;
import com.demo.mortgage.exception.CustomerNotFound;
import com.demo.mortgage.exception.LoanOfferNotFound;

@ControllerAdvice
public class ApplicationExceptionHandler {

	private Logger logger = LoggerFactory.getLogger(this.getClass());	    
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
		ErrorResponse errorResp = new ErrorResponse();
		errorResp.setErrorCode(ExceptionMapperEnum.CONSTRAINT_VIOLATION.name());
		
		List<String> errors = new ArrayList<>(); 
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        logger.error("Error Message: {}-{} check{}",fieldName,errorMessage,ExceptionMapperEnum.valueOf(errorMessage).name());
	        errors.add(ExceptionMapperEnum.valueOf(errorMessage).getValue());
	    });
	    errorResp.setErrorMessage(errors);
	    return new ResponseEntity<>(errorResp, HttpStatus.BAD_REQUEST);	   
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(LoanOfferNotFound.class)
	public ResponseEntity<?> handleLoanOfferNotFoundExceptions(LoanOfferNotFound ex) {
		ErrorResponse errorResp = new ErrorResponse();
		errorResp.setErrorCode(ExceptionMapperEnum.LOAN_OFFER_NOT_FOUND.name());
		List<String> errors = new ArrayList<>(); 
		errors.add(ExceptionMapperEnum.LOAN_OFFER_NOT_FOUND.getValue());
		errorResp.setErrorMessage(errors);
		return new ResponseEntity<>(errorResp, HttpStatus.BAD_REQUEST);	   
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(CustomerNotFound.class)
	public ResponseEntity<?> handleCustomerNotFoundExceptions(CustomerNotFound ex) {
		ErrorResponse errorResp = new ErrorResponse();
		errorResp.setErrorCode(ExceptionMapperEnum.CUSTOMER_NOT_FOUND.name());
		List<String> errors = new ArrayList<>(); 
		errors.add(ExceptionMapperEnum.CUSTOMER_NOT_FOUND.getValue());
		errorResp.setErrorMessage(errors);
		return new ResponseEntity<>(errorResp, HttpStatus.BAD_REQUEST);	   
	}
}
