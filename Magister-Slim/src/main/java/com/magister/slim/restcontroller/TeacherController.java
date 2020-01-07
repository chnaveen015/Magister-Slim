package com.magister.slim.restcontroller;

import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.magister.slim.entity.Teacher;
import com.magister.slim.service.TeacherAppService;
import com.magister.slim.service.UserAppService;

@RestController
@RequestMapping("teacher")
public class TeacherController {
	@Autowired
	TeacherAppService teacherAppService;
	@Autowired
	UserAppService userAppService;
	

	@PostMapping()
	public Teacher addTeacherDetails(@RequestBody Teacher teacherDetails) throws ParseException {
		teacherDetails.setTeacherId(UserAppService.generateNumber());
		teacherDetails.setActive(true);
		Teacher status = teacherAppService.addTeacher(teacherDetails);
		return status;
	}

	@RequestMapping(value = "{teacherId}", method = RequestMethod.DELETE)
	public Teacher removeTeacher(@PathVariable("teacherId") String teacherId) {
		Teacher status=teacherAppService.removeTeacherDetails(teacherId);
		return status;
	}
	
	@RequestMapping(value = "{teacherId}", method = RequestMethod.PUT)
	public Teacher updateTeacherDetails(@PathVariable("teacherId") String teacherId,@RequestBody Teacher teacher) {
		teacher.setTeacherId(teacherId);
		Teacher status = teacherAppService.updateTeacher(teacher);
		return status;
	}

	@RequestMapping(value = "{teacherId}", method = RequestMethod.GET)
	public Teacher getGroupDetails(@PathVariable("teacherId") String teacherId) {
		Teacher teacherDetails=teacherAppService.getTeacherDetailsById(teacherId);
			
		return teacherDetails;

	}
	@GetMapping()
	public Teacher getTeacherDetailsByName(@RequestParam("teacherName") String teacherName) {
		return teacherAppService.getTeacherByName(teacherName);

	}
	}
