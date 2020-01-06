package com.magister.slim.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class MagisterInterceptorConfig implements WebMvcConfigurer {
	
	@Autowired
	MagisterInterceptor magisterInterceptor;
	
	@Override
	   public void addInterceptors(InterceptorRegistry registry) {
	      registry.addInterceptor(magisterInterceptor).excludePathPatterns("/login","/studyGuides");
	   }
}
