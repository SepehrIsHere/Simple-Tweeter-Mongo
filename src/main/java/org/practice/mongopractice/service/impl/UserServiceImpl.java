package org.practice.mongopractice.service.impl;

import lombok.RequiredArgsConstructor;
import org.practice.mongopractice.config.MapperUtil;
import org.practice.mongopractice.dto.UserDto;
import org.practice.mongopractice.entities.User;
import org.practice.mongopractice.exception.UserNotFoundException;
import org.practice.mongopractice.exception.UserOperationException;
import org.practice.mongopractice.repository.UserRepository;
import org.practice.mongopractice.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final MapperUtil mapperUtil;

    @Override
    public UserDto save(User user) {
        try {
            userRepository.save(user);
            return mapperUtil.convertToDto(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserOperationException(e.getMessage());
        }
    }

    @Override
    public void update(User user) {
        try {
            userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserOperationException(e.getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserOperationException(e.getMessage());
        }
    }

    @Override
    public User findByEmail(String email) {
        try {
            return userRepository.findByEmail(email);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserOperationException(e.getMessage());
        }
    }

    @Override
    public UserDto findByFirstNameAndLastName(String firstName, String lastName) {
        try {
            return mapperUtil.convertToDto(userRepository.findByFirstNameAndLastName(firstName, lastName));
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserOperationException(e.getMessage());
        }
    }

    @Override
    public UserDto register(UserDto userDto) {
        try {
            save(mapperUtil.convertToEntity(userDto));
            return userDto;
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserOperationException("An error occurred while registering a user");
        }
    }

    @Override
    public List<UserDto> findAll() {
        try {
            return userRepository.findAll()
                    .stream()
                    .map(mapperUtil::convertToDto)
                    .toList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserOperationException("An error occurred while finding all users");
        }
    }

    @Override
    public void delete(UserDto userDto) {
        try {
            userRepository.delete(mapperUtil.convertToEntity(userDto));
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserOperationException("An error occured while deleting a user ");
        }
    }

    @Override
    public User findById(Long id) {
        try {
            return userRepository.findByUserId(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserOperationException("An error occured while finding user by id");
        }
    }
}
