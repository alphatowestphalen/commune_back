package com.back.commune.security.services.impl;


import com.back.commune.exceptions.NotFoundDataException;
import com.back.commune.model.auth.Role;
import com.back.commune.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.commune.security.services.RoleService;

import java.util.List;

@Service(value = "roleService")
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleDao;

    @Autowired
    public RoleServiceImpl(RoleRepository roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role findByName(String name) {
        return roleDao.findRoleByName(name);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDao.findAll();
    }

    @Override
    public Role findById(Long id) {
        return roleDao.findById(id).orElseThrow(() -> new NotFoundDataException("Role not found"));
    }

    @Override
    public void saveAll(List<Role> roles) {
        roleDao.saveAll(roles);
    }
}
