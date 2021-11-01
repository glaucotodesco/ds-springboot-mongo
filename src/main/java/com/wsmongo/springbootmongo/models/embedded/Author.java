package com.wsmongo.springbootmongo.models.embedded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.wsmongo.springbootmongo.models.entities.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    private String id;
    private String name;

    public Author(User entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }
}
