package com.back.commune.repository;

import com.back.commune.model.auth.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	   User findByUsername(String username);

	  Page<User> findAll(Pageable pageable);

      @Query("select u from User u where lower(u.name) like lower(concat(:nom,'%'))")
      Page<User> findSearchAll(@Param("nom")String nom, Pageable pageable);
}
