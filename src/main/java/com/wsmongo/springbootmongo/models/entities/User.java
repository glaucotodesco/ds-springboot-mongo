package com.wsmongo.springbootmongo.models.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Document(collection = "users")
public class User {

	@Id
    private String id;
	
	@NonNull
	private String name;

	@NonNull
	private String email;

	@DBRef(lazy = true)
	
	public List<Post> posts = new ArrayList<>();
}
