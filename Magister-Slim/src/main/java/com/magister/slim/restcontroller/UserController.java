package com.magister.slim.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.magister.slim.entity.User;
import com.magister.slim.service.UserAppService;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	UserAppService userAppService;

	@GetMapping()
	public List<User> getUserDetails() {
		return null;
	}

	@PostMapping("")
	public void createUser(@RequestBody() User user) {
		 userAppService.addUserDetails(user);
	}

	@DeleteMapping("{userId}")
	public void DeleteUserDetails(@RequestParam("userId") String userId) {

	}

	@PutMapping("{userId}")
	public void updateCourseDetails(@RequestParam("userId") String userId, @RequestBody() User user) {
	}
}
