package com.pms.dao;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "pensioner_detail")
public class PensionerDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private Date dob;
	private String panNumber;
	private double salary;
	private double allowances;
	private String mode;
	
	// @OneToOne(cascade = CascadeType.ALL)
	// @JoinColumn(name="accountNumber")
	// @PrimaryKeyJoinColumn
	// private BankDetail bankDetail;

	private String bankName;
	private String accountNumber;
	private String bankType;

	@ManyToOne
	@JoinColumn(name = "pension_input", nullable = false)
	private ProcessPensionInput pensionInput;
}
