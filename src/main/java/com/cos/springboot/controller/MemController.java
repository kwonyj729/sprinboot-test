package com.cos.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.springboot.dto.RequestMemJoinDto;
import com.cos.springboot.dto.RequestMemUpdateDto;

import com.cos.springboot.model.Mem;
import com.cos.springboot.repository.MemRepository;

@Controller
public class MemController {
	
	@Autowired      //이게 바로 DI 하는 방법이다.
	private MemRepository memRepository;
	
	@GetMapping("/mem/join")
	public String memJoin(){
		return "mem/join";
	}
	  
	
	// username, password, email
	@PostMapping("/mem/api/join")     //api 붙여주는 이유는??
	public @ResponseBody ResponseEntity<String> memApiJoin(@RequestBody RequestMemJoinDto requestMemJoinDto) {
		
		int result = memRepository.save(requestMemJoinDto);
		
		if(result == 1) {
//			return new ResponseEntity<String>("회원가입 성공", HttpStatus.ok)
			return new ResponseEntity<String>("ok", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("fail",HttpStatus.BAD_REQUEST);
		}
	}
		
	@GetMapping("/mem")
	public String mems (Model model) {
		List<Mem> mems = memRepository.findAll();
		
		model.addAttribute("mems", mems);
		
		return "mem/list";
	}
	
	@GetMapping("/mem/{id}")
	public String update(@PathVariable int id, Model model) {
		Mem mem = memRepository.findById(id);
		
		model.addAttribute("mem", mem);
		
		return "mem/update";
		
	}
	
	
	@PutMapping("/mem/api/update")
	public @ResponseBody ResponseEntity<?> updateProc(@RequestBody RequestMemUpdateDto requestMemUpdateDto) {
			int result = memRepository.update(requestMemUpdateDto);
		
				if(result == 1) {       // 만약에 수정한 게 잘 들어갔는지, 그 내용을 리턴받아서 확인하고 싶다면 이렇게 한다???
					System.out.println("result : " +result);
					return new ResponseEntity<String>("ok", HttpStatus.OK);
				} else {
					return new ResponseEntity<String>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
				}
			
				
			}
	
	@DeleteMapping("/mem/api/delete/{id}")
	public @ResponseBody ResponseEntity<?> deleteProc(@PathVariable int id) {
			
		int result = memRepository.delete(id);

		if(result == 1) {     
			return new ResponseEntity<String>("ok", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
		
	}

		
	}
	
	
	
	


