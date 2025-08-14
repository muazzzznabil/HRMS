package com.HRMS.HRMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class WebController implements WebMvcConfigurer{
    
    @Override
    
    public void addViewControllers(ViewControllerRegistry registry){
        // Error
        // registry.addViewController("/Error").setViewName("/error");
        // registry.addViewController("/error").setViewName("/error");

        registry.addViewController("/login").setViewName("/user/login");
        registry.addViewController("/registration").setViewName("/user/registration");
        
        // Dashboard
        registry.addViewController("/").setViewName("dashboard");
    
        // Leave Application Form
        // registry.addViewController("/leave-application-form").setViewName("/leave_application/la_form");
        
    
    
    }


    
}