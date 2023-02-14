package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.auth.AuthToken;
import com.example.demo.model.auth.LoginUser;
import com.example.demo.model.auth.User;
import com.example.demo.model.auth.UserDto;

import com.example.demo.security.jwt.TokenProvider;

import com.example.demo.security.services.UserService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> generateToken(@RequestBody LoginUser loginUser) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public User saveUser(@RequestBody UserDto user){
        return userService.save(user);
    }


    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        String token = authorizationHeader.substring(7); // remove "Bearer " prefix
        jwtTokenUtil.deleteToken(token);
        return ResponseEntity.ok("Logout successful");
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/adminping", method = RequestMethod.GET)
    public String adminPing(){
        return "Only Admins Can Read This";
    }

    @PreAuthorize("hasRole('USER') or hasRole('MAIRE')")
    @RequestMapping(value="/userping", method = RequestMethod.GET)
    public String userPing(){
        return "Any User Can Read This";
    }
    
    @PreAuthorize("hasRole('MAIRE')")
    @RequestMapping(value="/maireping", method = RequestMethod.GET)
    public String mairePing(){
        return "Any MAIRE Can Read This";
    }

}
