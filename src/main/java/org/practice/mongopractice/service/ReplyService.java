package org.practice.mongopractice.service;

import org.practice.mongopractice.dto.ReplyDto;
import org.practice.mongopractice.entities.Reply;
import org.practice.mongopractice.entities.Tweet;
import org.practice.mongopractice.entities.User;

import java.util.List;

public interface ReplyService {
    ReplyDto save(Reply reply);

    ReplyDto update(Reply reply);

    void delete(Reply reply);

    Reply findById(Long id);

    List<ReplyDto> findByUser(User user);

    List<ReplyDto> findByTweet(Tweet tweet);

    ReplyDto register(ReplyDto dto);
}
