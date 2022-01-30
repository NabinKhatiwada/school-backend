package com.school.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbl_student_bill")
@Getter
@Setter
public class StudentBillDB extends BaseClass implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "level_id", referencedColumnName = "id")
	private LevelDB level;
	
	@Column(name = "level_id", insertable = false, updatable = false)
	private Integer levelId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "achedemic_fee_id", referencedColumnName = "id")
	private AchedemicFeeDB achedemicFee;
	
	@Column(name = "achedemic_fee_id", insertable = false, updatable = false)
	private String achedemicFeeId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id", referencedColumnName = "id")
	private StudentDB student;

	@Column(name = "student_id", insertable = false, updatable = false)
	private Integer studentId;
	
	@Column(name = "monthly_fee")
	private Double monthlyFee;

	@Column(name = "scholarship_percentage")
	private Double scholarshipPercentage;

	@Column(name = "admission_fee")
	private Double admissionFee;

	@Column(name = "exam_fee")
	private Double examFee;

	@Column(name = "vehicle_fee")
	private Double vehicleFee;

	@Column(name = "tie_fee")
	private Double tieFee;

	@Column(name = "belt_fee")
	private Double beltFee;

	@Column(name = "annual_fee")
	private Double annualFee;

	@Column(name = "food_fee")
	private Double foodFee;

	@Column(name = "sports_fee")
	private Double sportsFee;

	@Column(name = "computer_fee")
	private Double computerFee;

	@Column(name = "learning_materials_fee")
	private Double learningMaterialsFee;

	@Column(name = "others_fee")
	private Double othersFee;
	
	@Column(name = "total_Amount")
	private Double totalAmount;
	
	@Column(name = "discount_amount")
	private Double discountAmount;
	
	@Column(name = "previous_balance")
	private Double previous_balance;
	
	@Column(name = "net_amount")
	private Double netAmount;
	
	@Column(name = "amount_received")
	private Double amountReceived;
	
	@Column(name = "balance")
	private Double balance;
	
	@Column(name = "remarks")
	private String remarks;
}