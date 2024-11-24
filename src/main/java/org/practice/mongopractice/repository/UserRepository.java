package org.practice.mongopractice.repository;

import org.practice.mongopractice.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {
    @Query("{'email' : :#{#email}}")
    User findByEmail(@Param("email") String email);

    @Query("$and: [ { 'firstName' : :#{#firstName} }, {'lastName' : :#{#lastName} } ]")
    User findByFirstNameAndLastName(@Param("firstName")String firstName,@Param("lastName")String lastName);
}
