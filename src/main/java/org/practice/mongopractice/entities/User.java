package org.practice.mongopractice.entities;

import lombok.*;
import org.practice.mongopractice.dto.UserDto;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collation = "users")
public class User {
    @Id
    private Long id;

    private String firstName;

    private String lastName;

    @Indexed
    private String email;

    private String password;

    private List<User> followers;

    private List<User> following;

    @DBRef
    private List<Reply> replies;

    @DBRef
    private List<Comment> comments;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
}
