package com.HRMS.HRMS.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HRMS.HRMS.model.user;

public interface UserRepository extends JpaRepository<user,Long>{
    
    Optional<user> findByUsername(String username);
}
