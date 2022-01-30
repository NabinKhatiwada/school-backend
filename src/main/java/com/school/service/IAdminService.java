package com.school.service;

import java.util.List;

import com.school.dto.AchedemicFeeDTO;

public interface IAdminService {

	void addAchedemicFee(AchedemicFeeDTO request);
	
	void updateAchedemicFee(AchedemicFeeDTO request);
	
	void deleteAchedemicFee(String achedemicFeeId);
	
	AchedemicFeeDTO getAchedemicFee(String achedemicFeeId);
	
	List<AchedemicFeeDTO> getAllAchedemicFees();
}
