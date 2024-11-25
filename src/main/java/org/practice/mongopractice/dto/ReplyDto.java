package org.practice.mongopractice.dto;

import lombok.*;
import org.practice.mongopractice.entities.Tweet;
import org.practice.mongopractice.entities.User;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReplyDto {
    private Long id;
    private String replyText;
    private User repliedUser;
    private Tweet tweet;
}
