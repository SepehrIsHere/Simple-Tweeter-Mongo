package org.practice.mongopractice.service.impl;

import lombok.RequiredArgsConstructor;
import org.practice.mongopractice.config.MapperUtil;
import org.practice.mongopractice.dto.ReplyDto;
import org.practice.mongopractice.entities.Reply;
import org.practice.mongopractice.entities.Tweet;
import org.practice.mongopractice.entities.User;
import org.practice.mongopractice.exception.ReplyIsNullException;
import org.practice.mongopractice.exception.ReplyOperationException;
import org.practice.mongopractice.exception.TweetNotFoundException;
import org.practice.mongopractice.exception.UserNotFoundException;
import org.practice.mongopractice.repository.ReplyRepository;
import org.practice.mongopractice.service.ReplyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {
    private final ReplyRepository replyRepository;
    private final MapperUtil mapperUtil;

    @Override
    public ReplyDto save(Reply reply) {
        try {
            if (reply == null) {
                throw new ReplyIsNullException("Reply is null or empty ");
            }
            replyRepository.save(reply);
            return mapperUtil.convertToDto(reply);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ReplyOperationException("An error occurred while saving a reply");
        }
    }

    @Override
    public ReplyDto update(Reply reply) {
        try {
            if (reply == null) {
                throw new ReplyIsNullException("Reply is null or empty ");
            }
            replyRepository.save(reply);
            return mapperUtil.convertToDto(reply);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ReplyOperationException("An error occurred while updating a reply");
        }
    }

    @Override
    public void delete(Reply reply) {
        try {
            if (reply == null) {
                throw new ReplyIsNullException("Reply is null or empty ");
            }
            replyRepository.delete(reply);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ReplyOperationException("An error occurred while deleting a reply");
        }
    }

    @Override
    public Reply findById(Long id) {
        try {
            return replyRepository.findReplyById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ReplyOperationException("An error occurred while finding a reply");
        }
    }

    @Override
    public List<ReplyDto> findByUser(User user) {
        try {
            if (user == null) {
                throw new UserNotFoundException("User is null or empty ");
            }
            return replyRepository.findByUser(user)
                    .stream()
                    .map(mapperUtil::convertToDto)
                    .toList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ReplyOperationException("An error occured while finding replies from user");
        }
    }

    @Override
    public List<ReplyDto> findByTweet(Tweet tweet) {
        try {
            if (tweet == null) {
                throw new TweetNotFoundException("Tweet is null or empty ");
            }
            return replyRepository.findByTweet(tweet).stream().map(mapperUtil::convertToDto).toList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ReplyOperationException("An error occurred while finding replies from tweet");
        }
    }
}
