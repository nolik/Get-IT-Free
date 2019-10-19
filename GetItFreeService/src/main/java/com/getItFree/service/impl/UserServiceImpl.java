package com.getItFree.service.impl;

import com.getItFree.dto.UserAdverts;
import com.getItFree.model.Advert;
import com.getItFree.model.AdvertStatus;
import com.getItFree.model.Authority;
import com.getItFree.model.User;
import com.getItFree.repository.AdvertRepository;
import com.getItFree.repository.UserRepository;
import com.getItFree.service.UserService;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static java.util.Collections.addAll;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AdvertRepository advertRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void resetCredentials() {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            user.setPassword(passwordEncoder.encode("123"));
            userRepository.save(user);
        }
    }

    @Override
    // @PreAuthorize("hasRole('USER')")
    public User findByUsername(String username) throws UsernameNotFoundException {
        User u = userRepository.findByUsername(username);
        return u;
    }

    @PreAuthorize("hasRole('ADMIN')")
    public User findById(Long id) throws AccessDeniedException {
//        User u = userRepository.findOne(id);
        return null;
    }

    //@PreAuthorize("hasRole('ADMIN')")
    public List<User> findAll() throws AccessDeniedException {
        List<User> result = userRepository.findAll();
        return result;
    }

    @Override
    public User save(User userRequest) {
        userRequest.setAuthority(List.of(Authority.ROLE_USER));
        userRequest.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        this.userRepository.save(userRequest);
        return userRequest;
    }

    @Override
    public Advert addAdvert(Long id, Advert advert) {
        User user = userRepository.findById(id).get();
        user.addAdvert(advert);
        advert.setGiver(user);
        advertRepository.save(advert);

        return advert;
    }

    @Override
    public Advert bookAdvert(Long userId, Long advertId) {
        Advert advert = advertRepository.findById(advertId).get();
        User userTaker = userRepository.findById(userId).get();
        advert.setTaker(userTaker);
        advert.setStatus(AdvertStatus.BOOKED);
        userTaker.decrKarma(1);

        return advert;
    }

    @Override
    public Advert acceptBookingAdvert(Long userId, Long advertId) {
        Advert advert = advertRepository.findById(advertId).get();
        User taker = userRepository.findById(advert.getTaker().getId()).get();
        advert.setStatus(AdvertStatus.ORDERED);
        taker.addTookAdvert(advert);
        taker.incKarma(1); //revert back karma; it was minus when booking see above com.getItFree.service.impl.UserServiceImpl.bookAdvert
        taker.decrKarma(advert.getPrice());
        User giver = userRepository.findById(userId).get();
        giver.incKarma(1);

        return advert;
    }

    private void throwError(Long id) {
        throw new RuntimeException("Not found " + id);
    }

    @Override
    public UserAdverts findAllUserAdverst(Long userId) {
        User user = userRepository.findById(userId).get();

        List<Advert> bookedAdverts = advertRepository.findAllByTaker_Id(userId);

        return new UserAdverts(user.getAdverts(), bookedAdverts);
    }
}
