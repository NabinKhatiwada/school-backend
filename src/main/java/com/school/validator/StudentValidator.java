package com.school.validator;

import org.springframework.http.HttpStatus;

import com.school.dto.LevelDTO;
import com.school.dto.SectionDTO;
import com.school.dto.StudentDTO;
import com.school.exception.CustomException;
import com.school.utils.CommonMethods;
import com.school.utils.IConstants;

public class StudentValidator {
	

	private static void validateRollNo(Integer rollNo) {
		if (CommonMethods.isEmpty(rollNo) || rollNo > 999) {
			throw new CustomException(HttpStatus.BAD_REQUEST, IConstants.ERR_MSG_BAD_REQUEST + "Roll No");
		}
	}

	public static void validateAddLevel(LevelDTO request) {
		CommonValidator.validateGeneralName(request.getName(), "Class");
	}

	public static void validateUpdateLevel(LevelDTO request) {
		CommonValidator.validateIdInt(request.getLevelId(), "Level ID");
		CommonValidator.validateGeneralName(request.getName(), "Class");
	}

	public static void validateAddSection(SectionDTO request) {
		CommonValidator.validateGeneralName(request.getName(), "Section ID");
	}

	public static void validateUpdateSection(SectionDTO request) {
		CommonValidator.validateIdInt(request.getSectionId(), "Section ID");
		CommonValidator.validateGeneralName(request.getName(), "Section");
	}

	public static void validateAddStudent(StudentDTO request) {
		CommonValidator.validateAddress(request.getAddress());
		CommonValidator.validateGender(request.getGender());
		CommonValidator.validateGeneralName(request.getName(), "Name");
		CommonValidator.validateGeneralName(request.getParentName(), "Parent Name");
		CommonValidator.validateGeneralName(request.getParentRelation(), "Parent Name");
		CommonValidator.validateMobileNo(request.getPhoneNumber());
		validateRollNo(request.getRollNo());
		CommonValidator.validateIdInt(request.getSectionId(), "Section ID");
	}

	public static void validateUpdateStudent(StudentDTO request) {
		CommonValidator.validateIdStr(request.getStudentId(), "Student ID");
		validateAddStudent(request);
	}

	

}
