package com.HRMS.HRMS.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.logging.Logger;

import org.date.date_diff;
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

        date_diff diff = new date_diff();
        LocalDate todayDate = LocalDate.now();

        Optional<user> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isEmpty()) {
            logger.info("User not found");
            throw new UsernameNotFoundException("User not found");
        }
        user user = optionalUser.get();

        long diffOfDays = 0;

        if (user.getLast_loggedIn_Date() != null) {
            diffOfDays = diff.dayDifferences(user.getLast_loggedIn_Date(),todayDate);
        }else{
        diffOfDays = 0;
    }

        user.setLast_loggedIn_Date(todayDate);
        user.setLast_loggedIn_Day(diffOfDays);

        userRepository.save(user);

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole().name().replace("ROLE_", ""))
                .build();
    }

}
