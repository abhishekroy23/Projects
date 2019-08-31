package com.demo.mortgage.mapper;

import org.mapstruct.Mapper;

import com.demo.mortgage.dto.CustomerDTO;
import com.demo.mortgage.entity.Customer;

@Mapper
public interface CustomerMapper {
	
	Customer customerDtoToEntityMap(CustomerDTO customerDTO);
	CustomerDTO customerEntityToDtoMap(Customer customer);

}
