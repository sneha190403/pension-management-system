package com.pms.pension.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.pension.dao.PensionDetail;

@Repository
public interface PensionDetailRepo extends JpaRepository<PensionDetail, Integer> {

}
