package com.magister.slim.restcontroller;

import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.magister.slim.entity.Student;
import com.magister.slim.repository.StudentInterface;
import com.magister.slim.service.StudentAppService;
import com.magister.slim.service.UserAppService;

@RestController
public class StudentController {

	@Autowired
	StudentAppService studentAppService;
	@Autowired
	StudentInterface studentInterface;
	@Autowired
	UserAppService userAppService;

	@RequestMapping(value = "student",method = RequestMethod.POST)
	public Student addStudent(@RequestBody Student studentDetails) throws ParseException {
		studentAppService.addStudentDetails(studentDetails);
		return studentDetails;
	}

	@RequestMapping(path = "group/{groupId}/student/{studentId}", method = RequestMethod.DELETE)
	public Student deleteStudentDetails(@RequestParam("studentId") String studenId) {
		System.out.println(studenId);
		Student student = studentAppService.deleteStudent(studenId);
		return student;
	}

	@RequestMapping(path = "group/{groupId}/student/{studentId}", method = RequestMethod.PUT)
	public Student updateStudentDetails(@RequestParam("studentId") String studentId, @RequestBody Student student) {
		// Student status = studentAppService.addStudent(student);
		return null;
	}

	@RequestMapping(value = "group/{groupId}/student/students", method = RequestMethod.GET)
	public Student getStudentDetails(@RequestParam String studentid) {
		Student student = studentAppService.getStudent(studentid);
		return student;

	}

}
