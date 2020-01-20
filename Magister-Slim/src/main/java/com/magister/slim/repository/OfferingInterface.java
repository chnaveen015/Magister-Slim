package com.magister.slim.repository;

import java.util.List; 

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.magister.slim.entity.Offering;

public interface OfferingInterface extends MongoRepository<Offering,String>{

	@Query("{'offeringName':?0}")
	List<Offering> getOfferingsByName(String offeringName);

}
