package com.magister.slim.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.magister.slim.entity.Student;
import com.magister.slim.service.StudentAppService;

@RestController
@RequestMapping("group/{groupId}/student")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

	@Autowired
	StudentAppService studentAppService;

	@RequestMapping(method = RequestMethod.POST)
	public Student addStudent(@RequestBody Student studentDetails) {
		studentDetails.setActive(true);
	//	studentDetails.setUserReference(studentDetails.getid());
		studentAppService.addStudentDetails(studentDetails);
		return null;
	}

	@RequestMapping(path="{studentId}",method = RequestMethod.DELETE)
	public Student deleteStudentDetails(@RequestParam("studentId") String studenId) {
		//Student status = studentAppService.deleteStudent(student);
		return null;
	}

	@RequestMapping(path="{studentId}",method = RequestMethod.PUT)
	public Student updateStudentDetails(@RequestParam("studentId") String studentId,@RequestBody Student student) {
	//	Student status = studentAppService.addStudent(student);
		return null;
	}

//	@RequestMapping(method = RequestMethod.GET)
//	public List<Student> get(@RequestParam String studentName) {
//		List<Student> students = studentAppService.getStudents(studentName);
//		return students;
//	}

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public Student getStudentDetails(@RequestParam String studentid) {
		Student student = studentAppService.getStudent(studentid);
		return student;

	}

}
