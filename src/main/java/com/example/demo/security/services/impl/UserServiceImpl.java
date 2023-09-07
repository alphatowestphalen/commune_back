package com.example.demo.security.services.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.demo.exceptions.NotFoundDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.auth.Role;
import com.example.demo.model.auth.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.services.RoleService;
import com.example.demo.security.services.UserService;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {
    @Autowired
    private RoleService roleService;
    private UserRepository userDao;
    private BCryptPasswordEncoder bcryptEncoder;

    @Autowired
    public UserServiceImpl( UserRepository userDao, BCryptPasswordEncoder bcryptEncoder) {
        this.userDao = userDao;
        this.bcryptEncoder = bcryptEncoder;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                Collections.singleton(getAuthority(user)));
    }

    private SimpleGrantedAuthority getAuthority(User user) {
        String roleName = "ROLE_" + user.getRoles();
        return new SimpleGrantedAuthority(roleName);
    }

    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        userDao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public User findOne(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public User save(User user) {
        User nUser = new User();
        nUser.setUsername(user.getUsername());
        nUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        nUser.setPhone(user.getPhone());
        nUser.setName(user.getName());
        nUser.setPoste(user.getPoste());
        if( !user.hasRole() ){
            Role role = roleService.findByName("PERSONEL");
            nUser.setRoles(role);
        }else{
            Role role = user.getRoles();
            role = roleService.findById(role.getId());
            nUser.setRoles(role);
        }
        return userDao.save(nUser);
    }
}
