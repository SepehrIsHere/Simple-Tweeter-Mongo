package org.practice.mongopractice.dto;

import lombok.*;
import org.practice.mongopractice.entities.User;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TweetDto {
    private Long id;
    private String postHeader;
    private String text;
    private User user;
}
