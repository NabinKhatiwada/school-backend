package com.school.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.school.utils.IConstants;

import lombok.Data;

@Data
public class SectionDTO {

	private Integer sectionId;
	
	@NotBlank
	private Integer levelId;

	@NotBlank
	@Size(min=1, max=IConstants.MAX_LENGTH_NAME)
	private String name;
	
}
