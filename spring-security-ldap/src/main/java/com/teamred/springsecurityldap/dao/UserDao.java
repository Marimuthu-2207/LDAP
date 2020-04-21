package com.teamred.springsecurityldap.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.teamred.springsecurityldap.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
}
