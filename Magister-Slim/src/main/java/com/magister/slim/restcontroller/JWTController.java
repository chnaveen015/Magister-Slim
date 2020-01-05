package com.magister.slim.restcontroller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.magister.slim.util.JWTUtil;

@RestController
public class JWTController {
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public String authentication(@RequestBody String payload)
	{
		String token=JWTUtil.generateToken(payload);
		boolean t=JWTUtil.verifyToken(token);
		System.out.println(token);
		System.out.println(t);
		return token;
	}

}
