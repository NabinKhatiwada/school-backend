package com.school.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.dto.LevelDTO;
import com.school.dto.SectionDTO;
import com.school.dto.StudentDTO;
import com.school.dto.payload.StudentSearchRequest;
import com.school.service.IStudentService;

@RestController
@RequestMapping("api")
@Validated
public class StudentController {

	@Autowired
	private IStudentService studentService;

	/* API for Levels */
	@GetMapping("level")
	@ResponseBody
	public ResponseEntity<?> getLevels() {
		return new ResponseEntity<>(studentService.getAllLevels(), HttpStatus.OK);
	}

	@PostMapping("level")
	@ResponseBody
	public ResponseEntity<?> createLevel(@Valid @RequestBody(required = true) LevelDTO level) {
		studentService.addLevel(level);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	@PutMapping("level")
	@ResponseBody
	public ResponseEntity<?> updateLevel(@Valid @RequestBody LevelDTO level) {
		studentService.updateLevel(level);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	@DeleteMapping("level/{id}")
	@ResponseBody
	public ResponseEntity<?> deleteLevel(@PathVariable(name = "id", required = true) Integer levelId) {
		studentService.deleteLevel(levelId);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	/* API for Sections */
	@GetMapping("section")
	@ResponseBody
	public ResponseEntity<?> getSections() {
		return new ResponseEntity<>(studentService.getAllSections(), HttpStatus.OK);
	}

	@PostMapping("section")
	@ResponseBody
	public ResponseEntity<?> createSection(@Valid @RequestBody SectionDTO sectionDTO) {
		studentService.addSection(sectionDTO);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	@PutMapping("section")
	@ResponseBody
	public ResponseEntity<?> updateSection(@Valid @RequestBody SectionDTO sectionDTO) {
		studentService.updateSection(sectionDTO);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	@DeleteMapping("section/{id}")
	@ResponseBody
	public ResponseEntity<?> deleteSection(@PathVariable(name = "id", required = true) Integer sectionId) {
		studentService.deleteSection(sectionId);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	/* API for Student */
	@GetMapping("student/{id}")
	@ResponseBody
	public ResponseEntity<?> getStudent(@PathVariable(name = "id", required = true) String studentId) {
		studentService.getStudent(studentId);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	@GetMapping("student")
	@ResponseBody
	public ResponseEntity<?> getStudents(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "50") Integer pageSize,
			@RequestBody(required = false) StudentSearchRequest request) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		return new ResponseEntity<>(studentService.getAllStudents(request, pageable), HttpStatus.OK);
	}

	@PostMapping("student")
	@ResponseBody
	public ResponseEntity<?> createStudent(@Valid @RequestBody StudentDTO studentDTO) {
		studentService.addStudent(studentDTO);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	@PutMapping("student")
	@ResponseBody
	public ResponseEntity<?> updateStudent(@Valid @RequestBody StudentDTO studentDTO) {
		studentService.updateStudent(studentDTO);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	@DeleteMapping("student/{id}")
	@ResponseBody
	public ResponseEntity<?> deleteStudent(@PathVariable(name = "id", required = true) String studentId) {
		studentService.deleteStudent(studentId);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	/* Student Bill */

}
