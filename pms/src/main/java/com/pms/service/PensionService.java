package com.pms.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.dao.PensionerDetail;
import com.pms.dao.ProcessPensionInput;
import com.pms.repository.ProcessPensionInputRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PensionService {

	@Autowired
	private ProcessPensionInputRepository pensionInputRepo;

	public PensionerDetail getPensionerDetailsByAadhaar(String aadhaarNumber) {

		Optional<ProcessPensionInput> optionalPensionInput = pensionInputRepo.findByAadhaarNumber(aadhaarNumber);
		PensionerDetail pensionerDetail;
		if (optionalPensionInput.isPresent()) {
			log.info("pension detail found : " + optionalPensionInput.get().getId());
			ProcessPensionInput processPensionInput = optionalPensionInput.get();
			Set<PensionerDetail> details = processPensionInput.getPensionerDetails();
			pensionerDetail = details.stream().findFirst().get();
		} else {
			log.info("pension detail not found");
			pensionerDetail = null;
		}

		return pensionerDetail;
	}
}
