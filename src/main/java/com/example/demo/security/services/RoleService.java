package com.example.demo.security.services;

import com.example.demo.model.auth.Role;

import java.util.List;

public interface RoleService {
    Role findByName(String name);
    List<Role> getAllRoles();

    Role findById(Long id);
    void saveAll(List<Role> roles);
}
