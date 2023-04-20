package com.pms.pension.dao;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PensionerDetail {

	private int id;

	private String name;
	private Date dob;
	private String panNumber;
	private double salary;
	private double allowances;
	private String accountNumber;
	private String mode;
	private String bankName;
	private String bankType;

}
