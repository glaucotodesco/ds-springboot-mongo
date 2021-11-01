package com.wsmongo.springbootmongo.repositories;

import java.time.Instant;
import java.util.List;

import com.wsmongo.springbootmongo.models.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * PostRepository
 */
@Repository
public interface PostRepository extends MongoRepository<Post, String>{

    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text);
	
    @Query("{ $and: [ { moment: {$gte: ?1} }, 													" +
    "                 { moment: { $lte: ?2} } , 												" +
    "		          { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, 						" +
    "		                      { 'body': { $regex: ?0, $options: 'i' } }, 			        " +
    "							  { 'comments.text': { $regex: ?0, $options: 'i' } }  	        " +
    "				 ] } 																        " +
    "        ] }")
	List<Post> fullSearch(String text, Instant startMoment, Instant endMoment);
    
    
}
