package com.getItFree.repository;

import com.getItFree.model.User;
import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, BigInteger> {
    User findByUsername(String username);
}