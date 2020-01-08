package com.magister.slim.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magister.slim.entity.User;
import com.magister.slim.entity.User.role;
import com.magister.slim.repository.StudentInterface;
import com.magister.slim.repository.UserInterface;
import com.magister.slim.util.JWTUtil;

@Service
public class LoginAppService {
	
	@Autowired
	UserInterface userInterface;
	
	@Autowired
	StudentInterface studentInterface;

	public User loginValidation(User user) {
		role role = null;
		user=userInterface.validateUser(user.getUsername(), user.getPassword());
		System.out.println(user);
		if(user!=null)
		return user;
		else
			return null;
	}

}