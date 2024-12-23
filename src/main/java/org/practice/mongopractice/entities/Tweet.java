package org.practice.mongopractice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "tweets")
public class Tweet {
    @Id
    private Long id;

    private String postHeader;

    private Long likes;

    private String text;

    @DBRef
    private User user;
}
