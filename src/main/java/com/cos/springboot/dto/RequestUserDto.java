package com.cos.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestUserDto {
	
	private String id;
	
	private String username;
	private String phone;

}
