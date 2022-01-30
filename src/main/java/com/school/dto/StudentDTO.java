package com.school.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.school.dto.payload.PaginationInfo;
import com.school.model.LevelDB;
import com.school.model.SectionDB;
import com.school.utils.IConstants;

import lombok.Data;

@Data
public class StudentDTO {
	
	private String studentId;
	
	private String createdDateStr;
	
	private String updateDateStr;
	
	@NotNull
	@Size(min=1, max=IConstants.MAX_LENGTH_NAME)
	private String name;
	
	@NotNull
	@Size(min=1, max=IConstants.MAX_LENGTH_ROLL_NO)
	private Integer rollNo;
	
//	private LevelDB level;
	
//	@NotNull
	private Integer levelId;

//	private SectionDB section;
	
	@NotNull
	private Integer sectionId;
	
	private Double scholarship;
	
	@NotNull
	private String parentName;
	
	@NotNull
	private String parentRelation;
	
	@NotNull
	private String phoneNumber;
	
	private String email;
	
	@NotNull
	private Integer age;
	
	@NotNull
	private String gender;
	
	private String religion;
	
	private Boolean vegetarianFlag = false;
	
	private Boolean vehicleFlag = false;
	
	@NotNull
	private String address;
	
}
