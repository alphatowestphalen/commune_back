package com.example.demo.security.services;

import com.example.demo.model.auth.Role;

public interface RoleService {
    Role findByName(String name);
}