package com.example.demo.security.services;


import java.util.List;

import com.example.demo.model.auth.User;
import com.example.demo.model.auth.UserDto;

public interface UserService {
    User save(UserDto user);
    List<User> findAll();
    User findOne(String username);
}
