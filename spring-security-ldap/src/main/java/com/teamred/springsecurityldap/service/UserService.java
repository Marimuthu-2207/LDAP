package com.teamred.springsecurityldap.service;

import com.teamred.springsecurityldap.dto.UserDto;
import com.teamred.springsecurityldap.model.User;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();
    
    User findOne(long id);
    
    User create(User user);
}
