package org.practice.mongopractice.service;

import org.practice.mongopractice.dto.TweetDto;
import org.practice.mongopractice.dto.UserDto;
import org.practice.mongopractice.entities.Tweet;

import java.util.List;

public interface TweetService {
    TweetDto save(Tweet tweet);

    void update(Tweet tweet);

    void delete(Tweet tweet);

    void deleteById(long id);

    List<TweetDto> findByUser(UserDto userDto);

    List<TweetDto> findAll();

    TweetDto findById(long id);

    TweetDto register(TweetDto tweetDto);
}
