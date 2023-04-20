package com.pms.pension.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pms.pension.dao.PensionDetail;
import com.pms.pension.dao.ProcessPensionInput;
import com.pms.pension.service.PensionService;

@RestController
public class PensionController {

	@Autowired
	private PensionService service;

	@PostMapping("/ProcessPension")
	public PensionDetail calculatePensionDetail(@RequestBody ProcessPensionInput processPensionInput, HttpServletRequest request) {

		String aadhaarNumber = processPensionInput.getAadhaarNumber();
		String accessToken = getAccessToken(request);
		return service.calculatePensionDetail(aadhaarNumber, accessToken);
	}
	
	private String getAccessToken(HttpServletRequest request) {
		String header = request.getHeader("Authorization");
		String token = header.split(" ")[1].trim();
		return token;
	}
}
