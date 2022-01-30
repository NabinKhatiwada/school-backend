package com.school.dto.payload;

import java.util.List;

import com.school.dto.StudentDTO;

import lombok.Data;

@Data
public class StudentListResponse {

	private List<StudentDTO> students;
	private com.school.dto.payload.PaginationInfo paginationInfo;
}
