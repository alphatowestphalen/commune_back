package com.example.demo.security.services;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.model.auth.User;


public interface UserService {
    
    User save(User user);

    List<User> findAll();

    User findOne(String username);

  
}
