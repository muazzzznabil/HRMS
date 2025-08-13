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

    public DataInit(UserRepository userRepository, PasswordEncoder passwordEncoder,
            InitialAdminProperties initialAdminProperties) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.initialAdminProperties = initialAdminProperties;
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
        }
    }

}
