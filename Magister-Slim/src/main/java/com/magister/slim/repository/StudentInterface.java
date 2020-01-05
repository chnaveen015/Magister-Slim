package com.magister.slim.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.magister.slim.entity.Student;

public interface StudentInterface extends MongoRepository<Student,String>{

}
