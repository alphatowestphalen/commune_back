package com.example.demo.controller;

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

import com.example.demo.model.Audit;
import com.example.demo.model.auth.AuthToken;
import com.example.demo.model.auth.LoginUser;
import com.example.demo.model.auth.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.jwt.TokenProvider;

import com.example.demo.security.services.UserService;
import com.example.demo.service.AuditService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AuditService auditService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> generateToken(@RequestBody LoginUser loginUser) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }


    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        System.out.println(authorizationHeader);
        String token = authorizationHeader.substring(7); // remove "Bearer " prefix
        jwtTokenUtil.deleteToken(token);
        return ResponseEntity.ok("Logout successful");
    }

    @PreAuthorize("hasRole('ADMIN')")
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

            User users = userRepository.findById(id).orElseThrow();
            
            
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
            User users = userRepository.findById(id).orElseThrow();

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
