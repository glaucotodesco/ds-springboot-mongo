package com.wsmongo.springbootmongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.wsmongo.springbootmongo.models.dtos.PostDTO;
import com.wsmongo.springbootmongo.models.dtos.UserDTO;
import com.wsmongo.springbootmongo.models.entities.User;
import com.wsmongo.springbootmongo.repositories.UserRepository;
import com.wsmongo.springbootmongo.resources.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

    public List<UserDTO> findAll() {
	    return repository.findAll().stream()
                                   .map( u -> new UserDTO(u))
                                   .collect(Collectors.toList());
		
	}
    
    public UserDTO findById(String id) {
        User user = getEntityById(id);
        return new UserDTO(user);
    }

    public UserDTO insert(UserDTO dto) {
		User entity = new User();
		copyDtoToEntity(dto, entity);
		entity = repository.insert(entity);
		return new UserDTO(entity);
	}

    public UserDTO update(String id, UserDTO dto) {
		User entity = getEntityById(id);
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new UserDTO(entity);
	}

    private User getEntityById(String id) {
        return repository.findById(id)
                         .orElseThrow( () -> new ResourceNotFoundException("Objeto não encontrado"));
    }

    private void copyDtoToEntity(UserDTO dto, User entity) {
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
	}

    public void delete(String id) {
		getEntityById(id);
		repository.deleteById(id);
	}

	public List<PostDTO> getUserPosts(String id) {
		User user = getEntityById(id);
		return user.getPosts().stream().map(x -> new PostDTO(x)).collect(Collectors.toList());
	}

}
