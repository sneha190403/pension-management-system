package com.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pms.dao.PensionerDetail;
import com.pms.dto.PensionerDetailDto;
import com.pms.dto.ResponseDto;
import com.pms.service.PensionService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PensionController {

	@Autowired
	private PensionService service;

	@GetMapping("/PensionerDetailByAadhaar")
	public ResponseEntity<ResponseDto> getPensionerDetailByAadhaar(
			@RequestParam("aadhaarNumber") String aadhaarNumber) {

		log.info("inside pms service pension detail");
		ResponseDto responseDto = new ResponseDto();

		PensionerDetail pensionerDetail = service.getPensionerDetailsByAadhaar(aadhaarNumber);

		if (pensionerDetail != null) {
			responseDto.setData(new PensionerDetailDto(pensionerDetail));
			responseDto.setSuccess(true);
			responseDto.setMessage("Record found !");
		} else {
			responseDto.setSuccess(false);
			responseDto.setMessage("Record not found !");
		}

		return ResponseEntity.status(HttpStatus.OK).body(responseDto);
	}
}
