package com.getItFree.service;

import com.getItFree.dto.UserAdverts;
import com.getItFree.model.Advert;
import com.getItFree.model.User;

import java.math.BigInteger;
import java.util.List;

public interface UserService {

    void resetCredentials();

    User findById(Long id);

    User findByUsername(String username);

    List<User> findAll();

    User save(User user);

    Advert addAdvert(Long userID, Advert advert);

    UserAdverts findAllUserAdverst(Long userId);

    Advert bookAdvert(Long userId, Long advertId);

    Advert acceptBookingAdvert(Long userId, Long advertId);
}
