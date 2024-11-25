package org.practice.mongopractice.repository;

import org.practice.mongopractice.entities.Comment;
import org.practice.mongopractice.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends MongoRepository<Comment, Long> {
    @Query("{'id' :  :#{#id}}")
    Comment findCommentById(@Param("id")Long id);

    @Query("{'user' : :#{#user}}")
    List<Comment> findByUser(@Param("user") User user);
}
