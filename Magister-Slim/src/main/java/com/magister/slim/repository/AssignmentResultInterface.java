package com.magister.slim.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.magister.slim.entity.AssignmentResult;

public interface AssignmentResultInterface extends MongoRepository<AssignmentResult,String>{

}
