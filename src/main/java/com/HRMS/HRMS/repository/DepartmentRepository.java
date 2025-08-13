package com.HRMS.HRMS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HRMS.HRMS.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long>{
    
    // List<Department> findAll();



}
