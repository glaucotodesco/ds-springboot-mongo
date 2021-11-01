package com.wsmongo.springbootmongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.wsmongo.springbootmongo.models.dtos.UserDTO;
import com.wsmongo.springbootmongo.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

    public List<UserDTO> findAll() {
	    return repository.findAll().stream()
                                   .map( u -> new UserDTO(u))
                                   .collect(Collectors.toList());
		
	}
    
}
