package com.auth.user.api;

import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequest {

	@Email @Length(min=5, max=50)
	private String email;
	
	@Length(min=4, max=20)
	private String password;
	
}
