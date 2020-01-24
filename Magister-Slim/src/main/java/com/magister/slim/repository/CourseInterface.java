package com.magister.slim.repository;



import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.magister.slim.entity.Course;
import com.magister.slim.entity.User;


public interface CourseInterface extends MongoRepository<Course,String>{

	@Query("{'courseName':?0}")
	Course getCourseByName(String courseName);
	@Query(value="{'isActive':?0}")
	public List<Course> getAllCourses(Boolean active);

}
