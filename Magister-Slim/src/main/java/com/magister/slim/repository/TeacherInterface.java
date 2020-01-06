package com.magister.slim.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.magister.slim.entity.Teacher;

public interface TeacherInterface extends MongoRepository<Teacher,String>{
	@Query("{'name':?0}")
	Teacher getTeacherByName(String teacherName);

}
