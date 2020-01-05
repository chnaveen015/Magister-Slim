package com.magister.slim.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.magister.slim.entity.User;

public interface UserInterface extends MongoRepository<User,String>{
@Query(value="{'username':?0},{'password':?1},{'active':true}")
public User validateUser(String username,String password);
}
