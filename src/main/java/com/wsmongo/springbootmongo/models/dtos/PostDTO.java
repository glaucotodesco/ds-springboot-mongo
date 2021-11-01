package com.wsmongo.springbootmongo.models.dtos;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.wsmongo.springbootmongo.models.embedded.Author;
import com.wsmongo.springbootmongo.models.embedded.Comment;
import com.wsmongo.springbootmongo.models.entities.Post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
	private String id;
	private Instant moment;
	private String title;
	private String body;
	private Author author;

    private List<Comment> comments = new ArrayList<>();

    public PostDTO(Post entity) {
		this.id = entity.getId();
		this.moment = entity.getMoment();
		this.title = entity.getTitle();
		this.body = entity.getBody();
		this.author = entity.getAuthor();
		this.comments.addAll(entity.getComments());
	}
}
