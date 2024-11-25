package org.practice.mongopractice.service;

import org.practice.mongopractice.dto.CommentDto;
import org.practice.mongopractice.entities.Comment;
import org.practice.mongopractice.entities.User;

import java.util.List;

public interface CommentService {
    CommentDto save(Comment comment);

    CommentDto update(Comment comment);

    Comment findById(Long id);

    List<CommentDto> findByUser(User user);

    void delete(Comment comment);

    void deleteById(Long id);
}
