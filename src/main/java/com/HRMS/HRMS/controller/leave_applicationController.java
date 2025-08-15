package com.HRMS.HRMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.HRMS.HRMS.Enums.LeaveStatusEnum;
import com.HRMS.HRMS.model.Department;
import com.HRMS.HRMS.model.leave_application;
import com.HRMS.HRMS.model.user;
import com.HRMS.HRMS.repository.DepartmentRepository;
import com.HRMS.HRMS.repository.UserRepository;
import com.HRMS.HRMS.repository.leaveApplicationRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class leave_applicationController {

    @Autowired
    leaveApplicationRepository leaveApplicationRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @RequestMapping("/leave-application-form")
    public String leaveApplicationForm(Model model) {

        LeaveStatusEnum pendingStatusEnum = LeaveStatusEnum.PENDING;
        model.addAttribute("pendingStatus", pendingStatusEnum);

        return ("/leave_application/la_form");
    }

    // Employee List View
    @RequestMapping("/leave-application-list/employee")
    public String listLeaveApplication(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        user findUser = userRepository.findByUsername(currentPrincipalName).orElseThrow();
        List<leave_application> application_list = leaveApplicationRepository.findByEmployeeUser(findUser);

        model.addAttribute("application_list", application_list);

        return ("/leave_application/la_list");
    }

    // Manager List View
    @RequestMapping("/leave-application-list/manager")
    public String listLeaveApplicationManager(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        user findUser = userRepository.findByUsername(currentPrincipalName).orElseThrow();
        Department dept = findUser.getDepartment();

        List<leave_application> application_list = leaveApplicationRepository.findByEmployeeUser_department(dept);
        model.addAttribute("application_list", application_list);

        return ("/leave_application/la_list");
    }
    
    @PostMapping("/leave-application")
    public String addLeaveApplication(@ModelAttribute leave_application leave_application,
            @RequestParam String username) {

        user findUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        leave_application.setEmployeeUser(findUser);

        leaveApplicationRepository.save(leave_application);
        return ("redirect:/leave-application-list/employee");
    }

    @PostMapping("/leave-application/delete")
    public String deleteLeaveApplication(@RequestParam Long applicationId) {

        leaveApplicationRepository.deleteById(applicationId);

        return ("redirect:/leave-application-list/employee");
    }

    @PostMapping("/leave-application/approve")
    public String approveListApplication(@RequestParam Long applicationId) {

        leave_application findApp = leaveApplicationRepository.findById(applicationId).orElseThrow();
        findApp.setApplication_status(LeaveStatusEnum.APPROVED);

        leaveApplicationRepository.save(findApp);

        return ("redirect:/leave-application-list/manager");
    }

    @PostMapping("/leave-application/reject")
    public String rejectListApplication(@RequestParam Long applicationId, @RequestParam String rejectReason) {

        leave_application findApp = leaveApplicationRepository.findById(applicationId).orElseThrow();
        findApp.setApplication_status(LeaveStatusEnum.REJECTED);
        findApp.setReject_reason(rejectReason);

        leaveApplicationRepository.save(findApp);

        return ("redirect:/leave-application-list/manager");
    }

    @PostMapping("/leave-application/appeal")
    public String appealListApplication(@RequestParam Long applicationId, @RequestParam String appealReason) {

        leave_application findApp = leaveApplicationRepository.findById(applicationId).orElseThrow();
        findApp.setApplication_status(LeaveStatusEnum.APPEALED);
        findApp.setAppeal_reason(appealReason);

        leaveApplicationRepository.save(findApp);

        return ("redirect:/leave-application-list/manager");
    }

}
