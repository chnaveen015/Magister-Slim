package com.magister.slim.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.magister.slim.entity.OfferingLevel;

public interface OfferingLevelInterface extends MongoRepository<OfferingLevel,String>{
	@Query("{'offeringLevelName':?0}")
	OfferingLevel getOfferingLevelByName(String offeringLevelName);
}
