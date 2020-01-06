package com.magister.slim.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.magister.slim.entity.Course;


public interface CourseInterface extends MongoRepository<Course,String>{

	@Query("{'courseName':?0}")
	Course getCourseByName(String courseName);

}
