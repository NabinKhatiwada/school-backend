package com.school.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbl_achedemic_fee")
@Getter
@Setter
public class AchedemicFeeDB extends BaseClass implements Serializable {

	private static final long serialVersionUID = 1L;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "level_id", referencedColumnName = "id")
	private LevelDB level;

	@Column(name = "level_id", insertable = false, updatable = false)
	private Integer levelId;

	@Column(name = "admission_fee")
	private Double admissionFee;

	@Column(name = "monthly_fee")
	private Double monthlyFee;

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
}
