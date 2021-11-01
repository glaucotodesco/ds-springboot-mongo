package com.wsmongo.springbootmongo.config;

import java.time.Instant;
import java.util.Arrays;

import javax.annotation.PostConstruct;

import com.wsmongo.springbootmongo.models.embedded.Author;
import com.wsmongo.springbootmongo.models.embedded.Comment;
import com.wsmongo.springbootmongo.models.entities.Post;
import com.wsmongo.springbootmongo.models.entities.User;
import com.wsmongo.springbootmongo.repositories.PostRepository;
import com.wsmongo.springbootmongo.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * TestConfig
 */
@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @PostConstruct
    public void init(){
        
        userRepository.deleteAll();
        postRepository.deleteAll();
		
		User maria = new User("Maria Brown", "maria@gmail.com");
		User alex = new User("Alex Green", "alex@gmail.com");
		User bob = new User("Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(Instant.parse("2021-02-13T11:15:01Z"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new Author(maria));
		Post post2 = new Post(Instant.parse("2021-02-14T10:05:49Z"), "Bom dia", "Acordei feliz hoje!", new Author(maria));

		Comment c1 = new Comment("Boa viagem mano!", Instant.parse("2021-02-13T14:30:01Z"), new Author(alex));
		Comment c2 = new Comment("Aproveite", Instant.parse("2021-02-13T15:38:05Z"), new Author(bob));
		Comment c3 = new Comment("Tenha um ótimo dia!", Instant.parse("2021-02-14T12:34:26Z"), new Author(alex));

		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));

		postRepository.saveAll(Arrays.asList(post1, post2));

		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);		
    }

    
}