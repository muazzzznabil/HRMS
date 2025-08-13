package com.HRMS.HRMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.HRMS.HRMS.model.Department;
import com.HRMS.HRMS.repository.DepartmentRepository;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DepartmentController {

    @Autowired
    DepartmentRepository departmentRepository;

    @RequestMapping("/departments")
    public String listDepartment(Model model) {
        List<Department> departments = departmentRepository.findAll();
        model.addAttribute("departments", departments);
        return ("DMP/dmp_list");
    }

    @PostMapping("/departments")
    public String addNewDepartments(@RequestParam String department_name) {
        Department department = new Department();
        department.setDepartment_name(department_name);
        departmentRepository.save(department);
        return ("redirect:/departments");
    }

    // Delete Department
    @PostMapping("/departments/delete")
    public String deleteDepartments(@RequestParam Long department_id) {
        departmentRepository.deleteById(department_id);
        return ("redirect:/departments");
    }

    // Update Department
    @PostMapping("/departments/update")
    public String updateDepartments(@RequestParam String department_name, @RequestParam Long department_id) {
        Department dept = departmentRepository.findById(department_id).orElseThrow();
        dept.setDepartment_name(department_name);
        departmentRepository.save(dept);

        return ("redirect:/departments");
    }

}
