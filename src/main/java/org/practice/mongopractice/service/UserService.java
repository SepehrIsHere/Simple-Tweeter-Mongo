package org.practice.mongopractice.service;

import org.practice.mongopractice.dto.UserDto;
import org.practice.mongopractice.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDto save(User user);

    void update(User user);

    void deleteById(Long id);

    void delete(UserDto userDto);

    List<UserDto> findAll();

    User findByEmail(String email);

    UserDto findByFirstNameAndLastName(String firstName, String lastName);

    UserDto register(UserDto userDto);

    User findById(Long id);
}
