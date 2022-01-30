package com.school.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


import lombok.Data;

@Data
public class LevelDTO  implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer levelId;

	@NotEmpty
	@NotBlank
	private String name;
}
