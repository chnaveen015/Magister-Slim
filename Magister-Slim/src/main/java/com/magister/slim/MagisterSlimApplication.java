<<<<<<< HEAD
package com.magister.slim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MagisterSlimApplication {

	public static void main(String[] args) {
		SpringApplication.run(MagisterSlimApplication.class, args);
	}

}
=======
package com.magister.slim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MagisterSlimApplication {

	public static void main(String[] args) {
		SpringApplication.run(MagisterSlimApplication.class, args);
	}
	
}
>>>>>>> Removed Cross Origins
