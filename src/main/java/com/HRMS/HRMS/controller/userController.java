package com.HRMS.HRMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.HRMS.HRMS.repository.UserRepository;

@Controller
public class userController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

}
