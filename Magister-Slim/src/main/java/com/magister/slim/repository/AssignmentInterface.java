package com.magister.slim.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.magister.slim.entity.Assignment;

public interface AssignmentInterface extends MongoRepository<Assignment,String>{

	@Query("{'assignmentName':?0}")
	List<Assignment> getAssignments(String assignmentName);

}
