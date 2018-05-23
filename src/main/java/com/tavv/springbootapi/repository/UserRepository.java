package com.tavv.springbootapi.repository;

import com.tavv.springbootapi.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByUserId(String userId);

    @Query("{userName : ?0}")
    List<User> findByUserName(String userName);

    @Query("{displayName: ?0}")
    List<User> findByDisplayName(String displayName);

}
