package com.getItFree.repository;

import com.getItFree.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

public interface UserRepository extends MongoRepository<User, BigInteger> {
    User findUserByUsername(String username);
}