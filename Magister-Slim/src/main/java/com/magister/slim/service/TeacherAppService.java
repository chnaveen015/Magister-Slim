package com.magister.slim.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magister.slim.entity.Group;
import com.magister.slim.entity.Teacher;
import com.magister.slim.references.GroupReference;
import com.magister.slim.repository.TeacherInterface;

@Service
public class TeacherAppService {
	
	@Autowired
	TeacherInterface teacherInterface;
	@Autowired
	UserAppService userAppService;
	@Autowired
	GroupAppService groupAppService;
	
	public List<Teacher> getTeachers()
	{
		List<Teacher> teachers=teacherInterface.findAll();
		return teachers;
	}
	
	public Teacher addTeacher(Teacher teacher)
	{
		if(userAppService.addUser(teacher))
		return teacherInterface.save(teacher);
		else return null;
		
	}
	public Teacher getTeacher(String teacherid) {
		Teacher teacher=teacherInterface.findById(teacherid).get();
		return teacher;
	}
	public Teacher removeTeacherDetails(String teacherId) {
		Teacher teacherDetails = teacherInterface.findById(teacherId).get();
		teacherDetails.setActive(false);
		teacherInterface.save(teacherDetails);
		boolean status=groupAppService.deleteTeacherReference(teacherDetails);
		return teacherDetails;
	}

	public boolean updateGroupReferences(Group groupDetails) {
		List<GroupReference> groupReferences = new ArrayList<GroupReference>();
		if(teacherInterface.findById(groupDetails.getTeacherReference().getTeacherid()).isPresent())
		{
		Teacher teacher = teacherInterface.findById(groupDetails.getTeacherReference().getTeacherid()).get();
		groupReferences = teacher.getGroupReference();
		if (groupReferences == null)
			groupReferences = new ArrayList<GroupReference>();
		groupReferences.add(new GroupReference(groupDetails.getGroupId(),groupDetails.getGroupName(),true));
		teacher.setGroupReference(groupReferences);
		if(teacherInterface.save(teacher)!=null)
		return true;
		}
		return false;
	}

	public Teacher updateTeacher(Teacher teacher) {
		if (teacherInterface.findById(teacher.getTeacherId()).isPresent()) {
			Teacher teacherDetails = teacherInterface.findById(teacher.getTeacherId()).get();
			teacherDetails.setName(teacher.getName());
			teacherInterface.save(teacherDetails);
			boolean status = groupAppService.updateTeacherReferenceDetails(teacher);
			return teacher;
		}
		return null;
	}

	public Teacher getTeacherDetailsById(String teacherId) {
		if ((teacherInterface.findById(teacherId).isPresent())) {
			Teacher teacherDetails = teacherInterface.findById(teacherId).get();
	
				return teacherDetails;

		} else
			return null;
	}

	public Teacher getTeacherByName(String teacherName) {
		Teacher teacherDetails = teacherInterface.getTeacherByName(teacherName);
	
			return teacherDetails;
	}
	
		
	}

