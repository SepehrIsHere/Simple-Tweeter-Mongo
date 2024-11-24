package org.practice.mongopractice.repository;

import org.practice.mongopractice.entities.Tweet;
import org.practice.mongopractice.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepository extends MongoRepository<Tweet,Long> {
    @Query("{'user' : :#{#user}}")
    List<Tweet> findByUser(@Param("user")User user);

    @Query("{'postHeader' : :#{#postHeader}}")
    Tweet findByPostHeader(@Param("postHeader")String postHeader);
}
