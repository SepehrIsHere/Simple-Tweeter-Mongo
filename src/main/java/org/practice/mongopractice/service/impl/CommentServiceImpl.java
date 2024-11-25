package org.practice.mongopractice.service.impl;

import lombok.RequiredArgsConstructor;
import org.practice.mongopractice.config.MapperUtil;
import org.practice.mongopractice.dto.CommentDto;
import org.practice.mongopractice.entities.Comment;
import org.practice.mongopractice.entities.User;
import org.practice.mongopractice.exception.CommentIsNullException;
import org.practice.mongopractice.exception.CommentOperationException;
import org.practice.mongopractice.exception.UserNotFoundException;
import org.practice.mongopractice.repository.CommentRepository;
import org.practice.mongopractice.service.CommentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final MapperUtil mapperUtil;

    @Override
    public CommentDto save(Comment comment) {
        try {
            if (comment == null) {
                throw new CommentIsNullException("Comment is null");
            }
            commentRepository.save(comment);
            return mapperUtil.convertToDto(comment);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CommentOperationException("An error occurred while saving the comment");
        }
    }

    @Override
    public CommentDto update(Comment comment) {
        try {
            if (comment == null) {
                throw new CommentIsNullException("Comment is null");
            }
            commentRepository.save(comment);
            return mapperUtil.convertToDto(comment);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CommentOperationException("An error occurred while updating the comment");
        }
    }

    @Override
    public Comment findById(Long id) {
        try {
            return commentRepository.findCommentById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CommentOperationException("An error occurred while finding the comment");
        }
    }

    @Override
    public List<CommentDto> findByUser(User user) {
        try {
            if (user == null) {
                throw new UserNotFoundException("User is null");
            }
            return commentRepository.findByUser(user)
                    .stream()
                    .map(mapperUtil::convertToDto)
                    .toList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new CommentOperationException("An error occurred while finding the comment");
        }
    }

    @Override
    public void delete(Comment comment) {
        try {
            if (comment == null) {
                throw new CommentIsNullException("Comment is null");
            }
            commentRepository.delete(comment);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CommentOperationException("An error occurred while deleting the comment");
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            commentRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CommentOperationException("An error occurred while deleting the comment");
        }
    }
}
