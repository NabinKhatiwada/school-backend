package com.school.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.dao.IAchedemicFeeDao;
import com.school.dao.ILevelDao;
import com.school.dto.AchedemicFeeDTO;
import com.school.exception.ResourceNotFoundException;
import com.school.model.AchedemicFeeDB;
import com.school.model.LevelDB;
import com.school.service.IAdminService;
import com.school.utils.DateUtils;
import com.school.utils.IConstants;
import com.school.validator.CommonValidator;
import com.school.validator.FeeValidator;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private IAchedemicFeeDao achedemicFeeDao;

	@Autowired
	private ILevelDao levelDao;

	@Override
	public void addAchedemicFee(AchedemicFeeDTO request) {
		FeeValidator.validateAddAchedemicFee(request);
		AchedemicFeeDB achedemicFeeDB = new AchedemicFeeDB();

		LevelDB levelDB = levelDao.getById(request.getLevelId());
		if (levelDB == null) {
			throw new ResourceNotFoundException(IConstants.ERR_MSG_NOT_FOUND + "level");
		}
		achedemicFeeDB.setAdmissionFee(request.getAdmissionFee());
		achedemicFeeDB.setAnnualFee(request.getAnnualFee());
		achedemicFeeDB.setBeltFee(request.getBeltFee());
		achedemicFeeDB.setComputerFee(request.getComputerFee());
		achedemicFeeDB.setExamFee(request.getExamFee());
		achedemicFeeDB.setFoodFee(request.getFoodFee());
		achedemicFeeDB.setLearningMaterialsFee(request.getLearningMaterialsFee());
		achedemicFeeDB.setLevel(levelDB);
		achedemicFeeDB.setMonthlyFee(request.getMonthlyFee());
		achedemicFeeDB.setOthersFee(request.getOthersFee());
		achedemicFeeDB.setSportsFee(request.getSportsFee());
		achedemicFeeDB.setTieFee(request.getTieFee());
		achedemicFeeDB.setVehicleFee(request.getVehicleFee());

		achedemicFeeDao.save(achedemicFeeDB);
	}

	@Override
	public void updateAchedemicFee(AchedemicFeeDTO request) {
		FeeValidator.validateUpdateAchedemicFee(request);
		AchedemicFeeDB achedemicFeeDB = achedemicFeeDao.findById(request.getAchedemicFeeId()).orElse(null);

		if (achedemicFeeDB == null) {
			throw new ResourceNotFoundException(IConstants.ERR_MSG_NOT_FOUND + "Achedemic Fee");
		}

		LevelDB levelDB = levelDao.getById(request.getLevelId());
		if (levelDB == null) {
			throw new ResourceNotFoundException(IConstants.ERR_MSG_NOT_FOUND + "level");
		}
		achedemicFeeDB.setUpdatedDateTime(new Date());
		achedemicFeeDB.setAdmissionFee(request.getAdmissionFee());
		achedemicFeeDB.setAnnualFee(request.getAnnualFee());
		achedemicFeeDB.setBeltFee(request.getBeltFee());
		achedemicFeeDB.setComputerFee(request.getComputerFee());
		achedemicFeeDB.setExamFee(request.getExamFee());
		achedemicFeeDB.setFoodFee(request.getFoodFee());
		achedemicFeeDB.setLearningMaterialsFee(request.getLearningMaterialsFee());
		achedemicFeeDB.setLevel(levelDB);
		achedemicFeeDB.setMonthlyFee(request.getMonthlyFee());
		achedemicFeeDB.setOthersFee(request.getOthersFee());
		achedemicFeeDB.setSportsFee(request.getSportsFee());
		achedemicFeeDB.setTieFee(request.getTieFee());
		achedemicFeeDB.setVehicleFee(request.getVehicleFee());

		achedemicFeeDao.save(achedemicFeeDB);
	}

	@Override
	public void deleteAchedemicFee(String achedemicFeeId) {
		CommonValidator.validateIdStr(achedemicFeeId, "Achedemic Fee");
		AchedemicFeeDB achedemicFeeDB = achedemicFeeDao.findById(achedemicFeeId).orElse(null);

		if (achedemicFeeDB == null) {
			throw new ResourceNotFoundException(IConstants.ERR_MSG_NOT_FOUND + "Achedemic Fee");
		}
		achedemicFeeDao.delete(achedemicFeeDB);
	}

	@Override
	public AchedemicFeeDTO getAchedemicFee(String achedemicFeeId) {
		CommonValidator.validateIdStr(achedemicFeeId, "Achedemic Fee");
		AchedemicFeeDB achedemicFeeDB = achedemicFeeDao.findById(achedemicFeeId).orElse(null);
		if (achedemicFeeDB == null) {
			throw new ResourceNotFoundException(IConstants.ERR_MSG_NOT_FOUND + "Achedemic Fee");
		}
		return convertAchedemicFeeDBtoDTO(achedemicFeeDB);
	}

	@Override
	public List<AchedemicFeeDTO> getAllAchedemicFees() {
		List<AchedemicFeeDB> dbList = achedemicFeeDao.findAll();
		List<AchedemicFeeDTO> dtoList = new ArrayList<>();
		for (AchedemicFeeDB dbObj : dbList) {
			AchedemicFeeDTO dto = convertAchedemicFeeDBtoDTO(dbObj);
			dtoList.add(dto);
		}
		return dtoList;
	}

	private AchedemicFeeDTO convertAchedemicFeeDBtoDTO(AchedemicFeeDB dbObj) {
		AchedemicFeeDTO achedemicFeeDTO = new AchedemicFeeDTO();
		achedemicFeeDTO.setAchedemicFeeId(dbObj.getId());
		achedemicFeeDTO.setAdmissionFee(dbObj.getAdmissionFee());
		achedemicFeeDTO.setAnnualFee(dbObj.getAnnualFee());
		achedemicFeeDTO.setBeltFee(dbObj.getBeltFee());
		achedemicFeeDTO.setComputerFee(dbObj.getComputerFee());
		achedemicFeeDTO.setUpdateDateStr(DateUtils.convertDateToStr(dbObj.getUpdatedDateTime()));
		achedemicFeeDTO.setExamFee(dbObj.getExamFee());
		achedemicFeeDTO.setFoodFee(dbObj.getFoodFee());
		achedemicFeeDTO.setLearningMaterialsFee(dbObj.getLearningMaterialsFee());
		achedemicFeeDTO.setLevelId(dbObj.getLevelId());
		achedemicFeeDTO.setMonthlyFee(dbObj.getMonthlyFee());
		achedemicFeeDTO.setOthersFee(dbObj.getOthersFee());
		achedemicFeeDTO.setSportsFee(dbObj.getSportsFee());
		achedemicFeeDTO.setTieFee(dbObj.getTieFee());
		achedemicFeeDTO.setVehicleFee(dbObj.getVehicleFee());

		return achedemicFeeDTO;
	}

}
