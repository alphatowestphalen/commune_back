package com.back.commune.repository;

import com.back.commune.model.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository <Role, Long> {
	 Role findRoleByName(String name);
}
