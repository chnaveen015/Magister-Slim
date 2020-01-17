package com.magister.slim.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magister.slim.entity.User;
import com.magister.slim.repository.StudentInterface;
import com.magister.slim.repository.UserInterface;

@Service
public class LoginAppService {

	@Autowired
	UserInterface userInterface;

	@Autowired
	StudentInterface studentInterface;

	public User loginValidation(User user) {
		user = userInterface.validateUser(user.getUsername(), user.getPassword());
		if (user != null)
			return user;
		else
			return null;
	}

}