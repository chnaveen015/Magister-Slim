package com.magister.slim.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.magister.slim.entity.Resource;

public interface ResourceInterface extends MongoRepository<Resource,String>{

	@Query("{'resourceName':?0}")
	List<Resource> getResources(String resourceName);

}
