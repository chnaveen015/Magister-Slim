<<<<<<< HEAD
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
=======
package com.magister.slim.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
@Configuration
public class MagisterInterceptorConfig implements WebMvcConfigurer {
	
	@Autowired
	MagisterInterceptor magisterInterceptor;
	
	@Override
	   public void addInterceptors(InterceptorRegistry registry) {
	      registry.addInterceptor(magisterInterceptor).excludePathPatterns("");
	   }
	@Bean
	public WebMvcConfigurer corsConfigurer() {
	   return new WebMvcConfigurer() {
	      @Override
	      public void addCorsMappings(CorsRegistry registry) {
	         registry.addMapping("/**")
	         .allowedMethods("GET","PUT","POST","DELETE")
	         .allowedHeaders("*")
	         .allowedOrigins("http://localhost:4200");
	  
	      }    
	   };
	}
	
}
>>>>>>> Removed Cross Origins
