package com.HRMS.HRMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class WebController implements WebMvcConfigurer{
    
    @Override
    
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/login").setViewName("/user/login");
        registry.addViewController("/").setViewName("dashboard");
        registry.addViewController("/registration").setViewName("/user/registration");
    }
}