package com.teamred.springsecurityldap.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamred.springsecurityldap.dto.ApiResponse;
import com.teamred.springsecurityldap.model.User;
import com.teamred.springsecurityldap.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/users")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    public static final String SUCCESS = "success";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_USER = "ROLE_USER";

    @Autowired
    private UserService userService;

    //@Secured({ROLE_ADMIN})
    @GetMapping
    public ApiResponse listUser(){
        log.info("received request to list user");
        return new ApiResponse(HttpStatus.OK, SUCCESS, userService.findAll());
    }

    //@Secured({ROLE_USER})
    @GetMapping(value = "/{id}")
    public ApiResponse getUser(@PathVariable long id){
        log.info("received request to update user %s");
        return new ApiResponse(HttpStatus.OK, SUCCESS, userService.findOne(id));
    }
    
    @PostMapping("/insert")
    public ApiResponse createUser(@RequestBody User user) {
    	return new ApiResponse(HttpStatus.OK, SUCCESS, userService.create(user));
    }

}
