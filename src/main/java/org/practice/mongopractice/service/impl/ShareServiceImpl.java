package org.practice.mongopractice.service.impl;

import lombok.RequiredArgsConstructor;
import org.practice.mongopractice.config.MapperUtil;
import org.practice.mongopractice.dto.TweetDto;
import org.practice.mongopractice.entities.Tweet;
import org.practice.mongopractice.entities.User;
import org.practice.mongopractice.exception.ShareOperationException;
import org.practice.mongopractice.exception.TweetOperationException;
import org.practice.mongopractice.exception.UnlikingTweetException;
import org.practice.mongopractice.exception.UserNotFoundException;
import org.practice.mongopractice.service.ShareService;
import org.practice.mongopractice.service.TweetService;
import org.practice.mongopractice.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ShareServiceImpl implements ShareService {
    private final TweetService tweetService;
    private final UserService userService;
    private final MapperUtil mapperUtil;

    @Override
    public TweetDto likeTweet(Long id) {
        try {
            Tweet tweet = mapperUtil.convertToEntity(tweetService.findById(id));
            tweet.setLikes(tweet.getLikes() + 1);
            tweetService.update(tweet);
            return mapperUtil.convertToDto(tweet);
        } catch (Exception e) {
            e.printStackTrace();
            throw new TweetOperationException("An error occurred while liking a tweet ");
        }
    }

    @Override
    public TweetDto unlikeTweet(Long id) {
        try {
            Tweet tweet = mapperUtil.convertToEntity(tweetService.findById(id));
            if (tweet.getLikes() == null || tweet.getLikes() == 0) {
                throw new UnlikingTweetException("Cant unlike the tweet because it has 0 likes ");
            }
            tweet.setLikes(tweet.getLikes() - 1);
            tweetService.update(tweet);
            return mapperUtil.convertToDto(tweet);
        } catch (Exception e) {
            e.printStackTrace();
            throw new TweetOperationException("An error occurred while unliking a tweet ");
        }
    }

    @Override
    public String followAUser(Long user, Long wantToFollow) {
        try {
            User firstUser = findUserById(user);
            User wantedToFollow = findUserById(wantToFollow);
            List<User> followingUsers = firstUser.getFollowing();
            followingUsers.add(wantedToFollow);
            firstUser.setFollowing(followingUsers);
            userService.update(firstUser);
            return wantedToFollow.getFirstName() + " successfully followed";
        } catch (Exception e) {
            e.printStackTrace();
            throw new ShareOperationException("An error occurred while following a User");
        }
    }

    @Override
    public String unfollowAUser(Long user, Long wantToUnfollow) {
        try{
            User firstUser = findUserById(user);
            User wantedToUnfollow = findUserById(wantToUnfollow);
            List<User> followingUsers = firstUser.getFollowing();
            if(!followingUsers.contains(wantedToUnfollow)){
                throw new UserNotFoundException("User not found");
            }
            followingUsers.remove(wantedToUnfollow);
            userService.update(firstUser);
            return wantedToUnfollow.getFirstName() + " successfully unfollowed";
        }catch (Exception e){
            e.printStackTrace();
            throw new ShareOperationException("An error occurred while unfollowing a User");
        }
    }

    private User findUserById(Long id){
        return userService.findById(id);
    }
}
