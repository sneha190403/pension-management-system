package com.pms.dao;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ProcessPensionInput {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String aadhaarNumber;

	@OneToMany(mappedBy = "pensionInput")
	private Set<PensionerDetail> pensionerDetails = new HashSet<>();

}
