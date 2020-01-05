package com.magister.slim.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.magister.slim.entity.Group;

public interface GroupInterface extends MongoRepository<Group,String>{

	@Query("{'groupName':?0}")
	List<Group> getGroupByName(String groupName);

}
