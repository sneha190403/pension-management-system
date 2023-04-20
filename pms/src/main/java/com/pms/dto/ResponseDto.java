package com.pms.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDto {

	private String message;

	private Object data;

	private boolean success;
}
