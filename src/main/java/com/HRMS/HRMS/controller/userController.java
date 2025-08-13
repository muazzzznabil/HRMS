package com.HRMS.HRMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.HRMS.HRMS.repository.UserRepository;

public class userController {

    @Autowired
    UserRepository userRepository;

    // @RequestMapping("/user")

    @PostMapping("/login")
    public void login() {

       userRepository.findByUsername(null);
    }

}
