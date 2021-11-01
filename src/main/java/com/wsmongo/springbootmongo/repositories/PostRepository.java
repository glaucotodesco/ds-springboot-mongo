package com.wsmongo.springbootmongo.repositories;

import com.wsmongo.springbootmongo.models.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * PostRepository
 */
@Repository
public interface PostRepository extends MongoRepository<Post, String>{
    
}
