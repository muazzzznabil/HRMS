package com.HRMS.HRMS.service;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.HRMS.HRMS.model.user;
import com.HRMS.HRMS.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    Logger logger = Logger.getLogger(CustomUserDetailsService.class.getName());

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<user> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isEmpty()) {
            logger.info("User not found");
            throw new UsernameNotFoundException("User not found");
        }

        user user = optionalUser.get();



        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole().name().replace("ROLE_", ""))
                .build();
    }


}
