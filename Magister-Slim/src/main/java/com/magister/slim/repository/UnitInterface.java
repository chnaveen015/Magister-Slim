package com.magister.slim.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.magister.slim.entity.Unit;

public interface UnitInterface extends MongoRepository<Unit,String>{

	@Query("{'unitName':?0}")
	List<Unit> getUnits(String unitName);

}
