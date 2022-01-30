package com.school.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.dto.AchedemicFeeDTO;
import com.school.service.IAdminService;

@RestController
@RequestMapping("api")
@Validated
public class AdminController {

	@Autowired
	private IAdminService adminService;

	/* Achedemic Fee */
	@GetMapping("achedemicFee")
	@ResponseBody
	public ResponseEntity<?> getAchedemicFees() {
		return new ResponseEntity<>(adminService.getAllAchedemicFees(), HttpStatus.OK);
	}

	@GetMapping("achedemicFee/{id}")
	@ResponseBody
	public ResponseEntity<?> getAchedemicFee(@PathVariable(name = "id") String feeId) {
		return new ResponseEntity<>(adminService.getAchedemicFee(feeId), HttpStatus.OK);
	}

	@DeleteMapping("achedemicFee/{id}")
	@ResponseBody
	public ResponseEntity<?> deleteAchedemicFee(@PathVariable(name = "id") String feeId) {
		adminService.deleteAchedemicFee(feeId);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	@PostMapping("achedemicFee")
	@ResponseBody
	public ResponseEntity<?> createAchedemicFee(@Valid @RequestBody(required = true) AchedemicFeeDTO request) {
		adminService.addAchedemicFee(request);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	@PutMapping("achedemicFee")
	@ResponseBody
	public ResponseEntity<?> updateAchedemicFee(@Valid @RequestBody(required = true) AchedemicFeeDTO request) {
		adminService.updateAchedemicFee(request);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

}
