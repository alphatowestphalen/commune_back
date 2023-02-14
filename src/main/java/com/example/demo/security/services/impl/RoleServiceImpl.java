package com.example.demo.security.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.auth.Role;
import com.example.demo.repository.RoleRepository;
import com.example.demo.security.services.RoleService;

@Service(value = "roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleDao;

    @Override
    public Role findByName(String name) {
        Role role = roleDao.findRoleByName(name);
        return role;
    }
}
