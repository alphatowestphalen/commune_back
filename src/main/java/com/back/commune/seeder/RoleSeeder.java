package com.back.commune.seeder;

import com.back.commune.model.auth.Role;
import com.back.commune.security.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
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
        if(roles.size() < 3){
            System.out.println("add all Roles");
            roleService.saveAll(getAllRoles());
        }
    }

    private List<Role> getAllRoles(){
        List<Role> roles = new ArrayList<Role>();
        roles.add(new Role("Maire"));
        roles.add(new Role("Responsable"));
        roles.add(new Role("Personel"));
        return roles;
    }
}
