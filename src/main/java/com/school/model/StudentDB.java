package com.school.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.school.utils.IConstants;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbl_student")
@Getter
@Setter
public class StudentDB extends BaseClass implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name = "name")
	@NotBlank
	@Size(min=1, max=IConstants.MAX_LENGTH_NAME)
	private String name;
	
	@Column(name = "roll_no")
	private Integer rollNo;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id", referencedColumnName = "id")
	private LevelDB level;
	
	@Column(name = "level_id",insertable = false ,updatable = false)
	private Integer levelId;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "section_id", referencedColumnName = "id")
	private SectionDB section;
	
	@Column(name = "section_id",insertable = false ,updatable = false)
	private Integer sectionId;
	
	@Column(name = "parent_name")
	private String parentName;
	
	@Column(name = "parent_relation")
	private String parentRelation;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "age")
	private Integer age;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "religion")
	private String religion;
	
	@Column(name = "vegetarian_flag")
	private Boolean vegetarianFlag;
	
	@Column(name = "vehicle_flag")
	private Boolean vehicleFlag;
	
	@Column(name = "address")
	private String address;
}
