package org.practice.mongopractice.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "comment")
public class Comment {
    @Id
    private Long id;

    private String text;

    @DBRef
    private User user;
}
