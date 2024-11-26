package org.practice.mongopractice.controller;

import lombok.RequiredArgsConstructor;
import org.practice.mongopractice.config.MapperUtil;
import org.practice.mongopractice.dto.TweetDto;
import org.practice.mongopractice.service.ShareService;
import org.practice.mongopractice.service.TweetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/share")
@RequiredArgsConstructor
public class ShareController {
    private final MapperUtil mapperUtil;
    private final ShareService shareService;
    private final TweetService tweetService;

    @PatchMapping("/like")
    public ResponseEntity<TweetDto> likeATweet(Long id){
        shareService.likeTweet(id);
        TweetDto tweetDto = tweetService.findById(id);
        return ResponseEntity.ok(tweetDto);
    }

    @PatchMapping("/unlike")
    public ResponseEntity<TweetDto> unlikeATweet(Long id){
        shareService.unlikeTweet(id);
        TweetDto tweetDto = tweetService.findById(id);
        return ResponseEntity.ok(tweetDto);
    }
}
