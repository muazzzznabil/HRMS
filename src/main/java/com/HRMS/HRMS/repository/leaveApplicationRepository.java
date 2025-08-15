package com.HRMS.HRMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HRMS.HRMS.model.Department;
import com.HRMS.HRMS.model.leave_application;
import com.HRMS.HRMS.model.user;

import java.util.List;


@Repository
public interface leaveApplicationRepository extends JpaRepository<leave_application, Long> {
    
    List<leave_application> findByEmployeeUser(user employeeUser);

    List<leave_application> findByEmployeeUser_department(Department department);

}
