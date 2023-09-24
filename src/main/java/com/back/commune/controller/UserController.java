package com.back.commune.controller;

import com.back.commune.model.Audit;
import com.back.commune.security.jwt.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.back.commune.model.auth.AuthToken;
import com.back.commune.model.auth.LoginUser;
import com.back.commune.model.auth.User;
import com.back.commune.repository.UserRepository;

import com.back.commune.security.services.UserService;
import com.back.commune.service.AuditService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AuditService auditService;

    @PostMapping(value = "/auth/login")
    public ResponseEntity<?> generateToken(@RequestBody LoginUser loginUser) throws AuthenticationException {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String access_token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(access_token));
    }


    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        System.out.println(authorizationHeader);
        String token = authorizationHeader.substring(7); // remove "Bearer " prefix
        jwtTokenUtil.deleteToken(token);
        return ResponseEntity.ok("Logout successful");
    }

    final String user = "hasRole('ADMIN')";
    @PreAuthorize(user)
    @RequestMapping(value = "/adminping", method = RequestMethod.GET)
    public String adminPing() {
        return "Only Admins Can Read This";
    }

    @PreAuthorize("hasRole('USER') or hasRole('MAIRE')")
    @RequestMapping(value = "/userping", method = RequestMethod.GET)
    public String userPing() {
        return "Any User Can Read This";
    }

    @PreAuthorize("hasRole('MAIRE')")
    @RequestMapping(value = "/maireping", method = RequestMethod.GET)
    public String mairePing() {
        return "Any MAIRE Can Read This";
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        try {
           User adduser = userService.save(user);
            return new ResponseEntity<>(adduser, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/users")
    public ResponseEntity<Map<String, Object>> getAllUser(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            List<User> listuser = new ArrayList<User>();
            Pageable paging = PageRequest.of(page, size);

            Page<User> pageuser;
            pageuser = userRepository.findAll(paging);

            if (pageuser.hasContent())

                listuser = pageuser.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("users", listuser);
            response.put("currentPage", pageuser.getNumber());
            response.put("totalItems", pageuser.getTotalElements());
            response.put("totalPages", pageuser.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @PutMapping("/users")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long id, @RequestBody User user ){
        try {

            User users = userRepository.findById(id).get();


            users.setName(user.getName());
            users.setUsername(user.getUsername());
            users.setPhone(user.getPhone());
            users.setPassword(user.getPassword());
            users.setPhone(user.getPhone());
            users.setPoste(user.getPoste());

            userService.save(user);

            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @DeleteMapping("/users")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable(value = "id") Long id){
        try {
            User users = userRepository.findById(id).get();

            userRepository.deleteById(users.getId());

            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/historiques")
    public List<Audit> getAllAudits(){
        List<Audit> listaudit = new ArrayList<>();
        listaudit = auditService.getAllAudits();
        return listaudit;
    }

    @GetMapping("/profile")
    public User currentUserName(Authentication authentication) {
        User user = userRepository.findByUsername(authentication.getName());
        return user;
    }
}
