package com.magister.slim.restcontroller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.magister.slim.entity.User;
import com.magister.slim.model.UserAuth;
import com.magister.slim.service.LoginAppService;
import com.magister.slim.service.UserAppService;
import com.magister.slim.util.JWTUtil;

@RestController
@RequestMapping("login")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

	@Autowired
	LoginAppService loginAppService;
	@Autowired
	UserAppService userAppService;
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public UserAuth insert(@RequestBody User user, HttpServletRequest request) {
		user.setActive(true);
		System.out.println("UserDetails Are:"+user);
		User status = loginAppService.loginValidation(user);
		if(status!=null && status.getPassword().equals(user.getPassword())&& status.isActive())
		{
			request.getServletContext().setAttribute("user", status);
		    return new UserAuth(JWTUtil.generateToken(user.getUsername()),(status.getRole()).toString());
		}
		else 
			return new UserAuth("invalid","");
	}
}
