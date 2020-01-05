package com.magister.slim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.magister.slim.entity.Student;
import com.magister.slim.repository.StudentInterface;

@Service
public class StudentAppService {
	
	@Autowired
	StudentInterface studentInterface;
	@Autowired
	UserAppService userAppService;
	
	public Student deleteStudent(Student student)
	{
		studentInterface.deleteById(student.getId());
		return student;
	}
	public List<Student> getStudents(String studentName)
	{
		List<Student> student1=studentInterface.findAll();
		return student1;
	}
	public Student getStudent(String studentid) {
		Student student=studentInterface.findById(studentid).get();
		return student;
	}
	public Student addStudentDetails(Student studentDetails) {
		return studentInterface.save(studentDetails);
	}
}
