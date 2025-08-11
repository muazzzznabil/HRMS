package com.HRMS.HRMS.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class userController {
    
@RequestMapping("/user")

@PostMapping("/login")
public String login(){
    return "sadsa"; //todo: fix
}

}
