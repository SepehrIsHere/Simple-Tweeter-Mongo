package org.practice.mongopractice.repository;

import org.practice.mongopractice.entities.Reply;
import org.practice.mongopractice.entities.Tweet;
import org.practice.mongopractice.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyRepository extends MongoRepository<Reply, Long> {
    @Query("{'id' : :#{#id}}")
    Reply findReplyById(@Param("id")Long id);

    @Query("{'repliedUser' : :#{#user}}")
    List<Reply> findByUser(@Param("user")User user);

    @Query("{'tweet' : :#{#tweet}}")
    List<Reply> findByTweet(@Param("tweet")Tweet tweet);
}
