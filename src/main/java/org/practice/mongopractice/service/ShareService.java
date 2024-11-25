package org.practice.mongopractice.service;

import org.practice.mongopractice.dto.TweetDto;

public interface ShareService {
    TweetDto likeTweet(Long id);

    TweetDto unlikeTweet(Long id);

    String followAUser(Long user,Long wantToFollow);

    String unfollowAUser(Long user,Long wantToUnfollow);

}
