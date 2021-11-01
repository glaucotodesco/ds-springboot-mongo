package com.wsmongo.springbootmongo.models.entities;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.wsmongo.springbootmongo.models.embedded.Author;
import com.wsmongo.springbootmongo.models.embedded.Comment;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection ="posts")
public class Post {
    
    @Id
    private String id;
    
    @NonNull
	private Instant moment;

    @NonNull
	private String title;

    @NonNull
	private String body;

    @NonNull
	private Author author;

    @Getter
    private List <Comment> comments = new ArrayList<>();
}
