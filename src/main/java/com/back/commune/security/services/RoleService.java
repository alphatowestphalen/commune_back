package com.back.commune.security.services;

import com.back.commune.model.auth.Role;

import java.util.List;

public interface RoleService {
    Role findByName(String name);
    List<Role> getAllRoles();

    Role findById(Long id);
    void saveAll(List<Role> roles);
}
