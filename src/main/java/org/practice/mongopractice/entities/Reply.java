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
@Document(collection = "reply")
public class Reply {
    @Id
    private Long id;

    private Long likes;

    @DBRef
    private User repliedUser;

    private String replyText;

    @DBRef
    private Tweet tweet;
}
