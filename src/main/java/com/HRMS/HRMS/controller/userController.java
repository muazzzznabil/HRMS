package com.HRMS.HRMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.HRMS.HRMS.Enums.RoleEnum;
import com.HRMS.HRMS.model.Department;
import com.HRMS.HRMS.model.user;
import com.HRMS.HRMS.repository.DepartmentRepository;
import com.HRMS.HRMS.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class userController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping("/user")
    public String ListAllUser(Model model) {
        List<Department> deptList = departmentRepository.findAll();
        List<user> userList = userRepository.findAll();
        RoleEnum[] roles = RoleEnum.values();
        model.addAttribute("Roles", roles);
        model.addAttribute("departmentList", deptList);
        model.addAttribute("users", userList);
        return ("user/user_list");
    }

    @PostMapping("/user")
    public String AddNewUser(@ModelAttribute user User) {

        String plainPass = User.getPassword();
        User.setPassword(passwordEncoder.encode(plainPass));

        userRepository.save(User);
        return ("redirect:/user");
    }

    // Delete User
    @PostMapping("/user/delete")
    public String deleteDepartments(@RequestParam Long user_id) {
        userRepository.deleteById(user_id);
        return ("redirect:/user");
    }

    //Update User
    @PostMapping("/user/update")
    public String updateUser(@ModelAttribute user User) {
        
        user existingUser = userRepository.findById(User.getUser_id()).orElseThrow();
        
        existingUser.setUsername(User.getUsername());
        existingUser.setFull_name(User.getFull_name());
        existingUser.setDepartment(User.getDepartment());
        existingUser.setRole(User.getRole());

        userRepository.save(existingUser);
        

        return ("redirect:/user");
    }
    

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

}
