package com.back.commune.security.services;


import java.util.List;

import com.back.commune.model.auth.User;

import com.back.commune.utils.ResponsePageable;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;


public interface UserService {

    User save(User user);

    List<User> findAll();

    User findById(String id);
    User findById(Long id);

    User findOne(String username);
    ResponsePageable<User> getSearchAll(String name, Pageable pageable);
    ResponsePageable<User> getAll(Pageable pageable);

    default User getAuthenticatedUser(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
            .getPrincipal();
        String username = userDetails.getUsername();
        return findOne(username);
    };
}
