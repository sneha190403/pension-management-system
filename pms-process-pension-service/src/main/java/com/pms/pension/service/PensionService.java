package com.pms.pension.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pms.pension.dao.PensionDetail;
import com.pms.pension.dao.PensionerDetail;
import com.pms.pension.dto.ResponseDto;
import com.pms.pension.repository.PensionDetailRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PensionService {
	
	@Autowired
	private PensionDetailRepo pensionDetailRepo;  

	// create a method to calculate pension amount and bank service charge called by
	// controller(ProcessPension method)
	// calls above method and take the particular pensionerDetails
	// calculate pension amt and charge
	public PensionDetail calculatePensionDetail(String aadhaarNumber, String accessToken) {

		PensionDetail pensionDetail = new PensionDetail();
		log.info("inside calculate pension detail");
		
	
		
		String url = "http://localhost:8080/PensionerDetailByAadhaar?aadhaarNumber=" + aadhaarNumber;
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(accessToken);

		HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(headers);

		ResponseEntity<ResponseDto> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity,
				ResponseDto.class);
		if (responseEntity.getStatusCode().is2xxSuccessful()) {
			log.info("response success : Pensioner details");
			ResponseDto response = responseEntity.getBody();
			if (response != null && response.isSuccess()) {
				PensionerDetail pensionerDetail = getPensionerObjectFromApiResponse(response.getData());
				double salary = pensionerDetail.getSalary();
				double allowances = pensionerDetail.getAllowances();
				String mode = pensionerDetail.getMode();

				if (mode.equalsIgnoreCase("self")) {
					pensionDetail.setPensionAmount(salary * 0.8 + allowances);
				} else {
					pensionDetail.setPensionAmount(salary * 0.5 + allowances);
				}

				if (pensionerDetail.getBankType().equalsIgnoreCase("public")) {
					pensionDetail.setBankServiceCharge(500);
				} else {
					pensionDetail.setBankServiceCharge(550);
				}
				pensionDetailRepo.save(pensionDetail);
				return pensionDetail;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	private PensionerDetail getPensionerObjectFromApiResponse(Object data) {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.convertValue(data, PensionerDetail.class);
	}

}
