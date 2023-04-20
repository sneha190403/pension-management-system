package com.pms.dto;

import java.util.Date;

import com.pms.dao.PensionerDetail;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PensionerDetailDto {

	private String name;
	private Date dob;
	private String panNumber;
	private String accountNumber;
	private String bankName;
	
	private double salary;
	private double allowances;
	private String mode;
	private String bankType;
	
	public PensionerDetailDto(PensionerDetail pensionerDetail) {
		this.name = pensionerDetail.getName();
		this.dob = pensionerDetail.getDob();
		this.panNumber = pensionerDetail.getPanNumber();
		this.accountNumber = pensionerDetail.getAccountNumber();
		this.bankName = pensionerDetail.getBankName();
		
		this.salary = pensionerDetail.getSalary();
		this.allowances = pensionerDetail.getAllowances();
		this.mode = pensionerDetail.getMode();
		this.bankType = pensionerDetail.getBankType();
	}

}
