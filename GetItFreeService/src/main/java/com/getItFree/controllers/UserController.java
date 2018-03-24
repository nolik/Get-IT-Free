package com.getItFree.controllers;

import com.getItFree.exception.ResourceConflictException;
import com.getItFree.model.User;
import com.getItFree.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigInteger;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(method = GET, value = "/user/{userId}")
    public User loadById(@PathVariable BigInteger userId) {
        return this.userService.findById(userId);
    }

    @RequestMapping(method = POST, value = "/signup")
    public ResponseEntity<?> addUser(@RequestBody User userRequest,
                                     UriComponentsBuilder ucBuilder) {

        User existUser = this.userService.findByUsername(userRequest.getUsername());
        if (existUser != null) {
            throw new ResourceConflictException(userRequest.get_id(), "Username already exists");
        }
        User user = this.userService.save(userRequest);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/user/{userId}").buildAndExpand(user.get_id()).toUri());
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @RequestMapping("/get-user-info")
    @PreAuthorize("hasRole('USER')")
    public User user() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
