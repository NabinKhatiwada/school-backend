package com.school.dto;

import lombok.Data;

@Data
public class StudentBillDTO {
	
	private String studentBillId;
	
	private String createdDateStr;

	private String updateDateStr;

	private Integer levelId;
	
	private String achedemicFeeId;

	private Integer studentId;
	
	private Double monthlyFee;

	private Double scholarshipPercentage;

	private Double admissionFee;

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
	
	private Double totalAmount;
	
	private Double discountAmount;
	
	private Double previous_balance;
	
	private Double netAmount;
	
	private Double amountReceived;
	
	private Double balance;
	
	private String remarks;
	
}
