package com.school.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.school.dao.ILevelDao;
import com.school.dao.ISectionDao;
import com.school.dao.IStudentDao;
import com.school.dto.LevelDTO;
import com.school.dto.payload.PaginationInfo;
import com.school.dto.payload.StudentListResponse;
import com.school.dto.payload.StudentSearchRequest;
import com.school.dto.SectionDTO;
import com.school.dto.StudentDTO;
import com.school.exception.ResourceNotFoundException;
import com.school.model.LevelDB;
import com.school.model.SectionDB;
import com.school.model.StudentDB;
import com.school.service.IStudentService;
import com.school.utils.CommonMethods;
import com.school.utils.DateUtils;
import com.school.utils.IConstants;
import com.school.validator.CommonValidator;
import com.school.validator.StudentValidator;

@Transactional
@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentDao studentDao;

	@Autowired
	private ILevelDao levelDao;

	@Autowired
	private ISectionDao sectionDao;

	@Override
	public void addLevel(LevelDTO request) {
		StudentValidator.validateAddLevel(request);
		LevelDB levelDB = new LevelDB();
		levelDB.setName(request.getName());

		levelDao.save(levelDB);
	}

	@Override
	public void updateLevel(LevelDTO request) {
		StudentValidator.validateUpdateLevel(request);
		LevelDB levelDB = levelDao.findById(request.getLevelId()).orElse(null);
		if (levelDB == null) {
			throw new ResourceNotFoundException(IConstants.ERR_MSG_NOT_FOUND + "class");
		}
		levelDB.setName(request.getName());
	}

	@Override
	public void deleteLevel(Integer levelId) {
		CommonValidator.validateIdInt(levelId, "Level Id");

		LevelDB levelDB = levelDao.findById(levelId).orElse(null);
		if (levelDB == null) {
			throw new ResourceNotFoundException(IConstants.ERR_MSG_NOT_FOUND + "class");
		}
		levelDao.delete(levelDB);
	}

	@Override
	public List<LevelDTO> getAllLevels() {
		List<LevelDTO> levelDTOList = new ArrayList<>();

		List<LevelDB> levels = levelDao.findAll();
		if (!CommonMethods.isEmpty(levels)) {
			for (LevelDB level : levels) {
				LevelDTO levelDTO = new LevelDTO();
				levelDTO.setLevelId(level.getId());
				levelDTO.setName(level.getName());
				levelDTOList.add(levelDTO);
			}
		}
		return levelDTOList;
	}

	@Override
	public void addSection(SectionDTO request) {
		StudentValidator.validateAddSection(request);

		LevelDB levelDB = levelDao.findById(request.getLevelId()).orElse(null);
		if (levelDB == null) {
			throw new ResourceNotFoundException(IConstants.ERR_MSG_NOT_FOUND + "class");
		}
		
		SectionDB sectionDB = new SectionDB();
		sectionDB.setName(request.getName());
		sectionDB.setLevel(levelDB);
		
		sectionDao.save(sectionDB);
	}

	@Override
	public void updateSection(SectionDTO request) {
		StudentValidator.validateUpdateSection(request);

		SectionDB sectionDB = sectionDao.findById(request.getSectionId()).orElse(null);
		if (sectionDB == null) {
			throw new ResourceNotFoundException(IConstants.ERR_MSG_NOT_FOUND + "section");
		}
		sectionDB.setName(request.getName());

		sectionDao.save(sectionDB);
	}

	@Override
	public void deleteSection(Integer sectionId) {
		CommonValidator.validateIdInt(sectionId, "Section Id");

		SectionDB sectionDB = sectionDao.findById(sectionId).orElse(null);
		if (sectionDB == null) {
			throw new ResourceNotFoundException(IConstants.ERR_MSG_NOT_FOUND + "section");
		}

		sectionDao.delete(sectionDB);
	}

	@Override
	public List<SectionDTO> getAllSections() {
		List<SectionDTO> sectionDTOList = new ArrayList<>();

		List<SectionDB> sections = sectionDao.findAll();
		if (!CommonMethods.isEmpty(sections)) {
			for (SectionDB section : sections) {
				SectionDTO sectionDTO = new SectionDTO();
				sectionDTO.setSectionId(section.getId());
				sectionDTO.setLevelId(section.getLevelId());
				sectionDTO.setName(section.getName());
				sectionDTOList.add(sectionDTO);
			}
		}
		return sectionDTOList;
	}

	@Override
	public void addStudent(StudentDTO request) {
		StudentValidator.validateAddStudent(request);

		SectionDB sectionDB = sectionDao.findById(request.getSectionId()).orElse(null);
		if (sectionDB == null) {
			throw new ResourceNotFoundException(IConstants.ERR_MSG_NOT_FOUND + "section");
		}
		StudentDB studentDB = new StudentDB();
		studentDB.setAddress(request.getAddress());
		studentDB.setAge(request.getAge());
		studentDB.setEmail(request.getEmail());
		studentDB.setGender(request.getGender());

		LevelDB levelDB = sectionDB.getLevel();
		studentDB.setLevel(levelDB);
		studentDB.setName(request.getName());
		studentDB.setParentName(request.getParentName());
		studentDB.setParentRelation(request.getParentRelation());
		studentDB.setPhoneNumber(request.getPhoneNumber());
		studentDB.setReligion(request.getReligion());
		studentDB.setRollNo(request.getRollNo());
		studentDB.setSection(sectionDB);
		studentDB.setVegetarianFlag(request.getVegetarianFlag());
		studentDB.setVehicleFlag(request.getVehicleFlag());

		studentDao.save(studentDB);
	}

	@Override
	public void updateStudent(StudentDTO request) {
		StudentValidator.validateUpdateStudent(request);

		StudentDB studentDB = studentDao.findById(request.getStudentId()).orElse(null);
		if (studentDB == null) {
			throw new ResourceNotFoundException(IConstants.ERR_MSG_NOT_FOUND + "Student");
		}
		studentDB.setUpdatedDateTime(new Date());

		SectionDB sectionDB = sectionDao.findById(request.getSectionId()).orElse(null);
		if (sectionDB == null) {
			throw new ResourceNotFoundException(IConstants.ERR_MSG_NOT_FOUND + "Section");
		}
		studentDB.setAddress(request.getAddress());
		studentDB.setAge(request.getAge());
		studentDB.setEmail(request.getEmail());
		studentDB.setGender(request.getGender());

		LevelDB levelDB = sectionDB.getLevel();
		studentDB.setLevel(levelDB);
		studentDB.setName(request.getName());
		studentDB.setParentName(request.getParentName());
		studentDB.setParentRelation(request.getParentRelation());
		studentDB.setPhoneNumber(request.getPhoneNumber());
		studentDB.setReligion(request.getReligion());
		studentDB.setRollNo(request.getRollNo());
		studentDB.setSection(sectionDB);
		studentDB.setVegetarianFlag(request.getVegetarianFlag());
		studentDB.setVehicleFlag(request.getVehicleFlag());

		studentDao.save(studentDB);

	}

	@Override
	public void deleteStudent(String studentId) {
		StudentDB studentDB = studentDao.findById(studentId).orElse(null);
		if (studentDB == null) {
			throw new ResourceNotFoundException(IConstants.ERR_MSG_NOT_FOUND + "Student");
		}
		studentDao.delete(studentDB);
	}

	@Override
	public StudentDTO getStudent(String studentId) {
		StudentDB studentDB = studentDao.findById(studentId).orElse(null);
		if (studentDB == null) {
			throw new ResourceNotFoundException(IConstants.ERR_MSG_NOT_FOUND + "Student");
		}
		StudentDTO studentDTO = convertStudentDTOFromDB(studentDB);
		
		
		return studentDTO;
	}

	@Override
	public StudentListResponse getAllStudents(StudentSearchRequest request, Pageable pageable) {
		StudentListResponse response = new StudentListResponse();

		Page<StudentDB> studentsPage = studentDao.findAll(pageable);
		PaginationInfo paginationInfo = CommonMethods.getPaginationInfo(studentsPage);
		response.setPaginationInfo(paginationInfo);

		List<StudentDTO> students = new ArrayList<>();
		for (StudentDB studentDB : studentsPage.getContent()) {
			StudentDTO studentDTO = convertStudentDTOFromDB(studentDB);
			students.add(studentDTO);
		}
		response.setStudents(students);
		return response;
	}

	public StudentDTO convertStudentDTOFromDB(StudentDB studentDB) {
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setCreatedDateStr(DateUtils.convertDateToStr(studentDB.getCreatedDateTime()));
		studentDTO.setUpdateDateStr(DateUtils.convertDateToStr(studentDB.getUpdatedDateTime()));
		studentDTO.setAddress(studentDB.getAddress());
		studentDTO.setAge(studentDB.getAge());
		studentDTO.setEmail(studentDB.getEmail());
		studentDTO.setGender(studentDB.getGender());

//		LevelDB levelDB = studentDB.getLevel();
//		studentDTO.setLevel(levelDB);
		studentDTO.setLevelId(studentDB.getLevelId());
		studentDTO.setName(studentDB.getName());
		studentDTO.setParentName(studentDB.getParentName());
		studentDTO.setParentRelation(studentDB.getParentRelation());
		studentDTO.setPhoneNumber(studentDB.getPhoneNumber());
		studentDTO.setReligion(studentDB.getReligion());
		studentDTO.setRollNo(studentDB.getRollNo());

//		SectionDB sectionDB = studentDB.getSection();
//		studentDTO.setSection(sectionDB);
		studentDTO.setSectionId(studentDB.getSectionId());
		studentDTO.setStudentId(studentDB.getId());
		studentDTO.setVegetarianFlag(studentDB.getVegetarianFlag());
		studentDTO.setVehicleFlag(studentDB.getVehicleFlag());

		return studentDTO;
	}

}
