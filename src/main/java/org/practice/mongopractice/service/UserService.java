package org.practice.mongopractice.service;

import org.practice.mongopractice.dto.UserDto;
import org.practice.mongopractice.entities.User;

public interface UserService {
    UserDto save(User user);

    void update(User user);

    void deleteById(Long id);

    UserDto findByEmail(String email);

    UserDto findByFirstNameAndLastName(String firstName, String lastName);
}
