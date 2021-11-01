package com.wsmongo.springbootmongo.repositories;

import com.wsmongo.springbootmongo.models.entities.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository
 */
@Repository
public interface UserRepository extends MongoRepository<User, String>{
    
}
