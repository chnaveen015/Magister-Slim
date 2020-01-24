package com.magister.slim.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.magister.slim.entity.Student;
import com.magister.slim.repository.StudentInterface;
import com.magister.slim.restcontroller.UserController;

@Service
public class StudentAppService {

	@Autowired
	StudentInterface studentInterface;
	@Autowired
	UserAppService userAppService;
	@Autowired
	UserController userController;

	public Student deleteStudent(String studenId) {
		Student student=studentInterface.findById(studenId).get();
		System.out.println(student);
		return student;
	}

	public List<Student> getStudents(String studentName) {
		List<Student> student1 = studentInterface.findAll();
		return student1;
	}

	public Student getStudent(String studentid) {
		Student student = studentInterface.findById(studentid).get();
		return student;
	}

	public Student addStudentDetails(Student studentDetails) throws ParseException {
		studentDetails.setId(UserAppService.generateNumber());
		studentDetails.setActive(true);
		studentDetails.setUserReference(userAppService.addUser(studentDetails));
		return studentInterface.save(studentDetails);
	}
}
