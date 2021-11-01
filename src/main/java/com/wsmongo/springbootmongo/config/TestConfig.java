package com.wsmongo.springbootmongo.config;

import java.util.Arrays;

import javax.annotation.PostConstruct;

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
    }

    
}