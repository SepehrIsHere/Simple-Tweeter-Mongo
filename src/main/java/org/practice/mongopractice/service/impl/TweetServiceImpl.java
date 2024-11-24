package org.practice.mongopractice.service.impl;

import lombok.RequiredArgsConstructor;
import org.practice.mongopractice.config.MapperUtil;
import org.practice.mongopractice.dto.TweetDto;
import org.practice.mongopractice.dto.UserDto;
import org.practice.mongopractice.entities.Tweet;
import org.practice.mongopractice.exception.TweetNotFoundException;
import org.practice.mongopractice.exception.TweetOperationException;
import org.practice.mongopractice.repository.TweetRepository;
import org.practice.mongopractice.service.TweetService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TweetServiceImpl implements TweetService {
    private final TweetRepository tweetRepository;
    private final MapperUtil mapperUtil;

    @Override
    public TweetDto save(Tweet tweet) {
        try {
            tweetRepository.save(tweet);
            return mapperUtil.convertToDto(tweet);
        } catch (Exception e) {
            e.printStackTrace();
            throw new TweetOperationException("An error occurred while saving the tweet");
        }
    }

    @Override
    public void update(Tweet tweet) {
        try {
            tweetRepository.save(tweet);
        } catch (Exception e) {
            e.printStackTrace();
            throw new TweetOperationException("An error occurred while updating the tweet");
        }
    }

    @Override
    public void delete(Tweet tweet) {
        try {
            tweetRepository.delete(tweet);
        } catch (Exception e) {
            e.printStackTrace();
            throw new TweetOperationException("An error occurred while deleting the tweet");
        }
    }

    @Override
    public void deleteById(long id) {
        try {
            tweetRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new TweetOperationException("An error occurred while deleting the tweet");
        }
    }

    @Override
    public List<TweetDto> findByUser(UserDto userDto) {
        try {
            return tweetRepository.findByUser(mapperUtil.convertToEntity(userDto))
                    .stream()
                    .map(mapperUtil::convertToDto)
                    .toList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new TweetOperationException("An error occurred while finding the tweet");
        }
    }

    @Override
    public List<TweetDto> findAll() {
        try {
            return tweetRepository.findAll()
                    .stream()
                    .map(mapperUtil::convertToDto)
                    .toList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new TweetOperationException("An error occurred while finding the tweet");
        }
    }

    @Override
    public TweetDto findById(long id) {
        try {
            Tweet tweet = tweetRepository.findById(id).orElseThrow(() -> new TweetNotFoundException("tweet not found"));
            return mapperUtil.convertToDto(tweet);
        } catch (Exception e) {
            e.printStackTrace();
            throw new TweetOperationException("An error occurred while finding the tweet");
        }
    }
}
