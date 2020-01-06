package com.magister.slim.service;

import java.util.List;
import java.util.Random;
import java.text.ParseException;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magister.slim.entity.Teacher;
import com.magister.slim.entity.User;
import com.magister.slim.repository.UserInterface;

@Service
public class UserAppService {

	@Autowired
	UserInterface userInterface;
	@Autowired
	StudentAppService studentAppService;

	public List<User> getUsers() {
		List<User> user = userInterface.findAll();
		return user;
	}

	public User deleteUser(User user) {
		userInterface.deleteById(user.getUserid());
		return user;
	}

	public User getUser(String userid) {
		User user = userInterface.findById(userid).get();
		return user;
	}

	public static String generatePassword() {
		int n = 9;
		String x;
		final Random RANDOM = new Random();
		String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		String digits = "0123456789";
		String splchar = "@!#$%&*?+-";
		StringBuilder returnValue = new StringBuilder(n);
		for (int i = 0; i < 4; i++) {
			returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		}
		returnValue.append(digits.charAt(RANDOM.nextInt(digits.length())));
		returnValue.append(splchar.charAt(RANDOM.nextInt(splchar.length())));
		returnValue.append(digits.charAt(RANDOM.nextInt(digits.length())));
		returnValue.append(splchar.charAt(RANDOM.nextInt(splchar.length())));
		x = returnValue.toString();
		return x;
	}

	public User addUserDetails(User user) {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	public static String generateNumber() throws ParseException {
		Calendar calendar = Calendar.getInstance();
		System.out.println("Calender - Time in milliseconds : " + calendar.getTimeInMillis());
		return Long.toString(calendar.getTimeInMillis());
	  }

	public boolean addUser(Teacher teacher) {
		// TODO Auto-generated method stub
		User user=new User(teacher.getTeacherId(),teacher.getName(),generatePassword(),new User().getRole().teacher,true);
		if(userInterface.save(user)!=null)
			return true;
		else return false;
		
	}
	

}
