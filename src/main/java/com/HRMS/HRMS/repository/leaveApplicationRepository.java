package com.HRMS.HRMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HRMS.HRMS.model.leave_application;

@Repository
public interface leaveApplicationRepository extends JpaRepository<leave_application, Long> {
    
}
