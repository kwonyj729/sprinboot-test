package com.cos.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;
// 이파일을 web.xml 파일을 자바 클래스 파일로 바꾼것과같다.
@Configuration    //IoC 하기 위해서 는 이거 꼭 써야함.
public class WebConfig implements WebMvcConfigurer {
	
	@Value("${file.path}")
	private String fileRealPath;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		
		//파일 경로 인식하게 하기.
		registry.addResourceHandler("/media/**")
		.addResourceLocations("file:///"+fileRealPath)
		.setCachePeriod(3600)
		.resourceChain(true)
		.addResolver(new PathResourceResolver());
	}
}
