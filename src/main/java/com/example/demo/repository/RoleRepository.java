package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.auth.Role;

@Repository
public interface RoleRepository extends JpaRepository <Role, Integer> {
	 Role findRoleByName(String name);
}
