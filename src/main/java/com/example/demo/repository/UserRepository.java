package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.auth.User;

@Repository
public interface UserRepository extends JpaRepository<User , Long>{
	
	   User findByUsername(String username);

	  Page<User> findAll(Pageable pageable);

}
