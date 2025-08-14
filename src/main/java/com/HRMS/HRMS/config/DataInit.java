package com.HRMS.HRMS.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.HRMS.HRMS.Enums.RoleEnum;
import com.HRMS.HRMS.model.user;
import com.HRMS.HRMS.repository.UserRepository;

@Component
public class DataInit implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final InitialAdminProperties initialAdminProperties;
    private final initialEmployeeProperties initialEmployeeProperties;
    private final initialManagerProperties initialManagerProperties;

    

    public DataInit(UserRepository userRepository, PasswordEncoder passwordEncoder,
            InitialAdminProperties initialAdminProperties, initialEmployeeProperties initialEmployeeProperties,initialManagerProperties InitialManagerProperties) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.initialAdminProperties = initialAdminProperties;
        this.initialEmployeeProperties = initialEmployeeProperties;
        this.initialManagerProperties = InitialManagerProperties;
    }

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findByUsername(initialAdminProperties.getUsername()).isEmpty()) {
            user adminUser = new user();
            adminUser.setUsername(initialAdminProperties.getUsername());
            adminUser.setPassword(passwordEncoder.encode(initialAdminProperties.getPassword()));
            adminUser.setRole(RoleEnum.ROLE_ADMIN);
            adminUser.setFull_name("admin");
            userRepository.save(adminUser);
        } if (userRepository.findByUsername(initialEmployeeProperties.getUsername()).isEmpty()) {
            user employeeUser = new user();
            employeeUser.setUsername(initialEmployeeProperties.getUsername());
            employeeUser.setPassword(passwordEncoder.encode(initialEmployeeProperties.getPassword()));
            employeeUser.setRole(RoleEnum.ROLE_EMPLOYEE);
            employeeUser.setFull_name("Employee");
            userRepository.save(employeeUser);
        } if (userRepository.findByUsername(initialManagerProperties.getUsername()).isEmpty()) {
            user managerUser = new user();
            managerUser.setUsername(initialManagerProperties.getUsername());
            managerUser.setPassword(passwordEncoder.encode(initialManagerProperties.getPassword()));
            managerUser.setRole(RoleEnum.ROLE_MANAGER);
            managerUser.setFull_name("Manager");
            userRepository.save(managerUser);
        }

    }

}
