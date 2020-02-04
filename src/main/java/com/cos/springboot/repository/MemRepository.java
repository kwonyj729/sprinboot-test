package com.cos.springboot.repository;

import java.util.List;

import com.cos.springboot.dto.RequestMemJoinDto;
import com.cos.springboot.dto.RequestMemUpdateDto;
import com.cos.springboot.model.Mem;

// MapperScan에 의해서 메모리에 자동으로 로드된다.   //컴포넌트 스캔을 할때 스캔되어서 미리 메모리에 떠 있다.
public interface MemRepository {          // 인터페이스라서 몸체 없다. 
	
	// 전체보기
	List<Mem> findAll();
	
	// 상세보기
	Mem findById(int id);
	
	// 회원가입
	int save(RequestMemJoinDto requestMemJoinDto);
	
	// 회원수정
	int update(RequestMemUpdateDto requestMemUpdateDto);
	
	// 회원삭제
	int delete(int id);
	
}
