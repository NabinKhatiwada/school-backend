package com.school.dto.payload;

import lombok.Data;

@Data
public class StudentSearchRequest {

	
	private Integer levelId;
	
	private Integer sectionId;
	
	private String phone;
	
	private String rollNo;
	
	private String name;
	
	private String gender;
	
}
