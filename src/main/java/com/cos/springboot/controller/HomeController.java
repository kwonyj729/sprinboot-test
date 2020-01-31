package com.cos.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.springboot.dto.RequestUserDto;
import com.cos.springboot.dto.ResponseData;



// localhost:8080/
// localhost:8080
@Controller
@RequestMapping("/home")
public class HomeController {
	
	
	// localhost:8080/home/
	// localhost:8080/home
	@GetMapping({"", "/"})
	public String home() {
		return "home";
	}
	
	
	// localhost:8080/home/hello
	@GetMapping("/hello")
	public String hello_get() {
		
		//System.out.println("왔니??");
		// DB select  하고나서 model에 담기.
		return "hello";
	}   //  요청할때 하이퍼링크로 보내면 된다. only!!!!
	
////////////////////////////////////////////////////////////////
	@PostMapping("/hello")
	public @ResponseBody ResponseData hello_post(@RequestBody RequestUserDto requestUserDto) {    //ajax 쓸거니까 viewResolver 가 관여 못하게 막아야 한다.
		//System.out.println("왔니??");
		// DB 연결해서 insert 하는 로직 필요함.
		System.out.println(requestUserDto.getId());
		
		return new ResponseData(200, "ok");
	}
	
	@DeleteMapping("/hello")
	public @ResponseBody ResponseData hello_delete(@RequestBody RequestUserDto requestUserDto) {
		//System.out.println("왔니??");
		// DB 연결해서 delete 하는 로직 필요함.
		System.out.println(requestUserDto.getId());
		
		return new ResponseData(200, "ok");
	}
	
	@PutMapping("/hello")
	public @ResponseBody ResponseData hello_update(@RequestBody RequestUserDto requestUserDto) {
		//System.out.println("왔니??");
		// DB 연결해서 put  하는 로직 필요함.
		System.out.println("username="+requestUserDto.getUsername()+" and "+ "phone=" + requestUserDto.getPhone());
		
		return new ResponseData(200, "ok");
	}

}
