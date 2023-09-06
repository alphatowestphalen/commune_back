package com.example.demo.seeder;

import com.example.demo.model.auth.Role;
import com.example.demo.security.services.RoleService;
import com.example.demo.security.services.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoleSeeder {
    @Autowired
    RoleService roleService;
    @EventListener(ApplicationReadyEvent.class)
    public void loadRolesData(){
        List<Role> roles = roleService.getAllRoles();
        System.out.println("Role seeder");
        if(roles.size() == 0){
            System.out.println("add all Roles");
            roleService.saveAll(getAllRoles());
        }
    }

    private List<Role> getAllRoles(){
        List<Role> roles = new ArrayList<Role>();
        roles.add(new Role("Maire"));
        roles.add(new Role("Responsable"));
        roles.add(new Role("Personnel"));
        return roles;
    }
}
