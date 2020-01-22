package com.magister.slim.restcontroller;

import static org.junit.Assert.*; 
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.magister.slim.entity.Teacher;
import com.magister.slim.entity.Teacher.gender;
import com.magister.slim.service.TeacherAppService;
import com.magister.slim.service.UserAppService;

public class TeacherControllerTest {

	
	@InjectMocks
	TeacherController teacherController;
	@Mock
	TeacherAppService teacherAppService;
	@Mock
	UserAppService userAppService;
	@Mock
	Teacher teacher;

	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
	}

	@Ignore
	@Test
	public void testAddTeacherDetails() throws ParseException {
		teacher.setName("teacher");
		when(teacherAppService.addTeacher(teacher)).thenReturn(teacher);
		Teacher addedTeacher = teacherController.addTeacherDetails(teacher);
		assertEquals(teacher, addedTeacher);
		assertEquals(teacher.getName(), addedTeacher.getName());
		verify(teacherAppService).addTeacher(teacher);
	}
	@Test
	public void testDeleteTeacherDetails()
	{
		String teacherId="123212131213";
		when(teacherAppService.removeTeacherDetails(teacherId)).thenReturn(new Teacher("naveen",18,gender.MALE,false));
		Teacher removeTeacher=teacherController.removeTeacher(teacherId);
		assertFalse(removeTeacher.isActive());
		verify(teacherAppService).removeTeacherDetails(teacherId);
	}
}
