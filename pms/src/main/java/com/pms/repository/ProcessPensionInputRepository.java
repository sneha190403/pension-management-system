package com.pms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.dao.ProcessPensionInput;

@Repository
public interface ProcessPensionInputRepository extends JpaRepository<ProcessPensionInput, Integer> {

	Optional<ProcessPensionInput> findByAadhaarNumber(String aadhaarNumber);

}
