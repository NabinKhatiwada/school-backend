package com.school.validator;

import org.springframework.http.HttpStatus;

import com.school.dto.StudentDTO;
import com.school.exception.CustomException;
import com.school.utils.CommonMethods;
import com.school.utils.IConstants;

public class CommonValidator {

	public static void validateGender(String gender) {
		if (CommonMethods.isEmpty(gender)) {
			throw new CustomException(HttpStatus.BAD_REQUEST, "Gender cannot be empty");
		}

		if (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female")
				&& !gender.equalsIgnoreCase("Other")) {
			throw new CustomException(HttpStatus.BAD_REQUEST, IConstants.ERR_MSG_BAD_REQUEST + "Gender");
		}
	}

	public static void validateAmount(Double amount) {
		if (amount == null || amount < 0 || amount > 9999999.00) {
			throw new CustomException(HttpStatus.BAD_REQUEST, "Invalid Amount");
		}
	}

	public static void validateIdStr(String id, String title) {
		if (CommonMethods.isEmpty(id)) {
			throw new CustomException(HttpStatus.BAD_REQUEST, "Invalid " + title + " Id");
		}
	}

	public static void validateIdInt(Integer id, String title) {
		if (id == null || id <= 0) {
			throw new CustomException(HttpStatus.BAD_REQUEST, "Invalid " + title + " Id");
		}
	}

	public static void validateGeneralName(String name, String title) {
		if (CommonMethods.isEmpty(name) || !name.matches(IConstants.REG_GENERAL_NAME)) {
			throw new CustomException(HttpStatus.BAD_REQUEST, "Invalid " + title);
		}
	}

	public static void validateMobileNo(String phoneNumber) {
		if (CommonMethods.isEmpty(phoneNumber) || !phoneNumber.matches(IConstants.REG_MOBILE_NO)) {
			throw new CustomException(HttpStatus.BAD_REQUEST, "Invalid Phone");
		}
	}

	public static void validateAddress(String address) {
		if (CommonMethods.isEmpty(address) || address.length() > IConstants.MAX_LENGTH_ADDRESS) {
			throw new CustomException(HttpStatus.BAD_REQUEST, "Invalid Address");
		}
	}

}
