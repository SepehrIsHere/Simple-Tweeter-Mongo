package org.practice.mongopractice.controller;

import lombok.RequiredArgsConstructor;
import org.practice.mongopractice.config.MapperUtil;
import org.practice.mongopractice.dto.TweetDto;
import org.practice.mongopractice.dto.UserDto;
import org.practice.mongopractice.entities.User;
import org.practice.mongopractice.service.TweetService;
import org.practice.mongopractice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tweet")
@RequiredArgsConstructor
public class TweetController {
    private final TweetService tweetService;
    private final UserService userService;
    private final MapperUtil mapperUtil;

    @PostMapping("/save")
    public ResponseEntity<TweetDto> register(@RequestBody TweetDto tweetDto) {
        tweetService.register(tweetDto);
        return ResponseEntity.ok(tweetDto);
    }

    @PatchMapping("/update")
    public ResponseEntity<String> update(@RequestParam Long id) {
        TweetDto tweetDto = tweetService.findById(id);
        tweetService.update(mapperUtil.convertToEntity(tweetDto));
        return ResponseEntity.ok("tweet with id : " + id + " have been updated ");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam Long id) {
        tweetService.deleteById(id);
        return ResponseEntity.ok("Deleted tweet with id : " + id);
    }

    @PostMapping("/find-by-email")
    public List<TweetDto> findUserTweet(@RequestParam String email) {
        User user = userService.findByEmail(email);
        return tweetService.findByUser(mapperUtil.convertToDto(user));
    }

    @GetMapping("/find-all")
    public List<TweetDto> findAll() {
        return tweetService.findAll();
    }


}
