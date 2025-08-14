package com.HRMS.HRMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.HRMS.HRMS.Enums.LeaveStatusEnum;
import com.HRMS.HRMS.model.leave_application;
import com.HRMS.HRMS.model.user;
import com.HRMS.HRMS.repository.UserRepository;
import com.HRMS.HRMS.repository.leaveApplicationRepository;
import com.HRMS.HRMS.service.CustomUserDetailsService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class leave_applicationController  {
    
    @Autowired
    leaveApplicationRepository leaveApplicationRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/leave-application-form")
    public String leaveApplicationForm(Model model) {

        LeaveStatusEnum pendingStatusEnum = LeaveStatusEnum.PENDING;
        model.addAttribute("pendingStatus", pendingStatusEnum);

        return ("/leave_application/la_form");
    }

    @RequestMapping("/leave-application-list/employee")
    public String listLeaveApplication(){

        

        return ("/leave_application/la_list");
    }
    

    @PostMapping("/leave-application")
    public String addLeaveApplication(@ModelAttribute leave_application leave_application , @RequestParam String username) {

        user findUser = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found") );

        leave_application.setEmployee_user(findUser);


        leaveApplicationRepository.save(leave_application);
        return ("redirect:/");
    }
    

}
