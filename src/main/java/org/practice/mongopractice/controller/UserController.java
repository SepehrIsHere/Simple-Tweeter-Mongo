package org.practice.mongopractice.controller;

import lombok.RequiredArgsConstructor;
import org.practice.mongopractice.config.MapperUtil;
import org.practice.mongopractice.dto.UserDto;
import org.practice.mongopractice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final MapperUtil mapperUtil;

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody UserDto userDto) {
        userService.register(userDto);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/email")
    public ResponseEntity<UserDto> findByEmail(@RequestParam String email) {
        UserDto userDto = userService.findByEmail(email);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/first-and-last")
    public ResponseEntity<UserDto> findByFirstNameAndLastName(@RequestParam String firstName, @RequestParam String lastName) {
        UserDto userDto = userService.findByFirstNameAndLastName(firstName, lastName);
        return ResponseEntity.ok(userDto);
    }

    @PatchMapping("/update")
    public ResponseEntity<String> update(@RequestParam String email) {
        userService.update(mapperUtil.convertToEntity(userService.findByEmail(email)));
        return ResponseEntity.ok("User with email " + email + " have been updated ");
    }

    @GetMapping("/all")
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody UserDto userDto) {
        userService.delete(userDto);
        return ResponseEntity.ok("User " + userDto.getEmail() + " deleted successfully");
    }
}
