package com.cos.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {   // 앞으로 Response 할때마다 공통적으로 쓸거라서 따로 만들어 놓으면 편하다.
	private int statusCode;
	private String msg;

}
