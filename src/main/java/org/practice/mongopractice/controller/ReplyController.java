package org.practice.mongopractice.controller;

import lombok.RequiredArgsConstructor;
import org.practice.mongopractice.config.MapperUtil;
import org.practice.mongopractice.dto.ReplyDto;
import org.practice.mongopractice.entities.User;
import org.practice.mongopractice.service.ReplyService;
import org.practice.mongopractice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reply")
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyService replyService;
    private final UserService userService;
    private final MapperUtil mapperUtil;

    @GetMapping("/user-all")
    public List<ReplyDto> getUsersReplies(@RequestParam Long id){
        User user = userService.findById(id);
        return replyService.findByUser(user);
    }

    @PostMapping("/save")
    public ResponseEntity<ReplyDto> saveReply(@RequestBody ReplyDto replyDto){
         replyService.register(replyDto);
         return ResponseEntity.ok(replyDto);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteReply(@RequestParam Long id){
        replyService.delete(replyService.findById(id));
        return ResponseEntity.ok("Reply with id of " + id + " deleted");
    }

    @PatchMapping
    public ResponseEntity<ReplyDto> updateReply(@RequestBody ReplyDto replyDto){
        replyService.update(mapperUtil.convertToEntity(replyDto));
        return ResponseEntity.ok(replyDto);
    }

}
