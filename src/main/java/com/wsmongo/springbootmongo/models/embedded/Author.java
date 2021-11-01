package com.wsmongo.springbootmongo.models.embedded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import com.wsmongo.springbootmongo.models.entities.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Author {
    
    private String id;

    @NonNull
    private String name;

    public Author(User entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }
}
