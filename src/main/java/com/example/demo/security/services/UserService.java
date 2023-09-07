package com.example.demo.security.services;


import java.awt.*;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.model.auth.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;


public interface UserService {

    User save(User user);

    List<User> findAll();

    User findById(String id);
    User findById(Long id);

    User findOne(String username);

    default User getAuthenticatedUser(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
            .getPrincipal();
        String username = userDetails.getUsername();
        return findOne(username);
    };
}
