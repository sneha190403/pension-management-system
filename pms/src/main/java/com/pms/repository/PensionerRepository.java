package com.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.dao.PensionerDetail;

@Repository
public interface PensionerRepository extends JpaRepository<PensionerDetail, Integer> {

}
