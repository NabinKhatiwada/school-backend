package com.school.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbl_level")
@Getter
@Setter
public class LevelDB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@NotBlank
	protected Integer id;

	@Column(name = "name")
//	@NotEmpty(message = "Please provide a name")
//	@NotBlank(message = "Please provide a name")
//	@Size(min=1, max=IConstants.MAX_LENGTH_NAME)
	private String name;

}
