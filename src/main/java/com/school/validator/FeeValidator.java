package com.school.validator;

import com.school.dto.AchedemicFeeDTO;

public class FeeValidator {

	public static void validateAddAchedemicFee(AchedemicFeeDTO request) {
		CommonValidator.validateIdInt(request.getLevelId(), "Level");
	}

	public static void validateUpdateAchedemicFee(AchedemicFeeDTO request) {
		CommonValidator.validateIdStr(request.getAchedemicFeeId(), "Achedemic Fee");
		CommonValidator.validateIdInt(request.getLevelId(), "Level");
	}

}
