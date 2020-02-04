package com.cos.springboot.dto;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RequestMemJoinDto {
	
	@NotBlank(message = "유저네임이 입력되지 않음.")
	private String username;
	
	@NotBlank(message="패스워드가 입력되지 않음.")
	private String password;
	
	@NotBlank(message="이메일이 입력되지 않음.")
	private String email;
	

}
