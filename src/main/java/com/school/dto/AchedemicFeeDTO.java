package com.school.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class AchedemicFeeDTO {

	private String achedemicFeeId;

	private String createdDateStr;

	private String updateDateStr;

	@NotEmpty
	@NotBlank
	private Integer levelId;

	private Double admissionFee;

	private Double monthlyFee;

	private Double examFee;

	private Double vehicleFee;

	private Double tieFee;

	private Double beltFee;

	private Double annualFee;

	private Double foodFee;

	private Double sportsFee;

	private Double computerFee;

	private Double learningMaterialsFee;

	private Double othersFee;
}
