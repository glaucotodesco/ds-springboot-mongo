package com.wsmongo.springbootmongo.models.embedded;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private String text;
    private Instant moment;
    private Author author;
}
