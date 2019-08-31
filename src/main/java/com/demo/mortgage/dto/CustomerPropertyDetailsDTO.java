package com.demo.mortgage.dto;

import javax.validation.constraints.NotNull;

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
public class CustomerPropertyDetailsDTO {

	private Long id;
	private String propType;
	private String propAddress;
	@NotNull(message = "PROPERTY_VALUE_MANDATORY")
	private Long propValue;

}
