package com.cos.springboot.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller      // Controller, Configuration, Repository
public class ImageController {
	
	@Value("${file.path}")   //DI 해주는 것이다.!!!!!!!!!!!!!!!!!
	private String fileRealPath;
	
	@PutMapping("/image/upload")
	public @ResponseBody String imageUpload(@RequestParam("imgFile") MultipartFile imgFile) {
		// 1번 imgFile 출력.
		System.out.println(imgFile);   //그냥 오브젝트 나옴.
		System.out.println(imgFile.getOriginalFilename());
		System.out.println(imgFile.getContentType());   // image/png  
		System.out.println(imgFile.getSize());  // 파일 크기.
		System.out.println(imgFile.getName());  //
		System.out.println();   // 위에 정보들을 통해서, 내가 보낸 이미지 파일에 대한 모든 정보를 알수있다.
//		try {
//			System.out.println(imgFile.getBytes().toString());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}		
		// 파일이름 중복될때 처리하는 방법.
		UUID uuid = UUID.randomUUID();
		String uuidFilename = uuid + "_" + imgFile.getOriginalFilename();
		
		// 파일 img 폴더는 외부에 잡아야한다. 그 이유는?   
//		Path filePath = Paths.get("C:/src/springbootWork/springboot-test/img/"+imgFile.getOriginalFilename());
		Path filePath = Paths.get(fileRealPath +uuidFilename);   // 디비에는  uuidFilename 라고 저장하면 된다.??
		// 메모리랑 하드디스크가 서로 통신 하려면, try-catch 를 이용해서 "통신" 하는 것이다.
		// 나중에 DB에는 파일 명(경로)만 저장하면 된다.
		try {
			Files.write(filePath, imgFile.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return "ok";
	}
}
