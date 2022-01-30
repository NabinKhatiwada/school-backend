package com.school.dto.payload;

import java.util.List;

import com.school.model.StudentDB;

import lombok.Data;

@Data
public class AllStudentsResponse {

	private List<StudentDB> students;
	private PaginationInfo paginationInfo;
}
