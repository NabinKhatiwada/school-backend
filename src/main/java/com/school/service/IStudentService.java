package com.school.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.school.dto.LevelDTO;
import com.school.dto.SectionDTO;
import com.school.dto.StudentDTO;
import com.school.dto.payload.StudentListResponse;
import com.school.dto.payload.StudentSearchRequest;

public interface IStudentService {
	
	/* Level */
	void addLevel(LevelDTO request);

	void updateLevel(LevelDTO request);

	void deleteLevel(Integer levelId);

	List<LevelDTO> getAllLevels();

	/* Section */
	void addSection(SectionDTO request);

	void updateSection(SectionDTO request);

	void deleteSection(Integer sectionId);

	List<SectionDTO> getAllSections();
	
	/* Student */
	void addStudent(StudentDTO request);
	
	void updateStudent(StudentDTO request);

	void deleteStudent(String studentId);
	
	StudentDTO getStudent(String studentId);

	StudentListResponse getAllStudents(StudentSearchRequest request, Pageable pageable);
	
	
}
