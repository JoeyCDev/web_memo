package com.majon.memo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.majon.memo.common.FileManagerService;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 서버(내 컴퓨터) 의 특정 위치의 파일들을
		// 내가 정한 url path로 접근하게 하는 설정
		
		registry.addResourceHandler("/images/**") // /images/3_32342342/test.png
		
		.addResourceLocations("file:///" + FileManagerService.FILE_UPLOAD_PATH);
		
	}
	

}
