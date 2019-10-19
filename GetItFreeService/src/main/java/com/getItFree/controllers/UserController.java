package com.getItFree.controllers;

import com.getItFree.dto.AdvertDTO;
import com.getItFree.dto.UserCredentialDTO;
import com.getItFree.dto.UserDTO;
import com.getItFree.exception.ResourceConflictException;
import com.getItFree.model.Advert;
import com.getItFree.model.User;
import com.getItFree.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @RequestMapping(method = GET, value = "/user/{userId}")
    public User loadById(@PathVariable Long userId) {
        return this.userService.findById(userId);
    }

    @GetMapping("/users")
    public List<UserDTO> findAllUsers() {

        return userService.findAll().stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/users/{userId}/adverts")
    public List<AdvertDTO> findAllUserAdverts(
            @PathVariable Long userId) {

        return userService.findAllUserAdverst(userId).stream()
                .map(advert -> modelMapper.map(advert, AdvertDTO.class))
                .collect(Collectors.toList());
    }

    @PostMapping("/users/{userId}/add-advert")
    public AdvertDTO addAdvert(
            @PathVariable Long userId,
            @RequestBody Advert advert){

        return modelMapper.map(userService.addAdvert(userId, advert), AdvertDTO.class);
    }

    @PutMapping("/users/{userId}/book-advert/{advertId}")
    public AdvertDTO bookAdvert(
            @PathVariable Long userId,
            @PathVariable Long advertId) {

        return modelMapper.map(userService.bookAdvert(userId, advertId), AdvertDTO.class);
    }

    @RequestMapping(method = POST, value = "/signup")
    public ResponseEntity<?> addUser(@RequestBody User userRequest,
                                     UriComponentsBuilder ucBuilder) {

        User existUser = this.userService.findByUsername(userRequest.getUsername());
        if (existUser != null) {
            throw new ResourceConflictException(userRequest.getId(), "Username already exists");
        }
        User user = this.userService.save(userRequest);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/user/{userId}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @RequestMapping("/get-user-info")
    @PreAuthorize("hasRole('USER')")
    public UserCredentialDTO user() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return modelMapper.map(user, UserCredentialDTO.class);
    }

}
