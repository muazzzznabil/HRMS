package com.HRMS.HRMS.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

                http
                                .authorizeHttpRequests((requests) -> requests
                                                .requestMatchers("/user/**", "/departments/**").hasRole("ADMIN")
                                                .requestMatchers("/leave-application-list/employee",
                                                                "/leave-application-form",
                                                                "/leave-application/appeal")
                                                .hasRole("EMPLOYEE")
                                                .requestMatchers("/leave-application-list/manager").hasRole("MANAGER")
                                                .requestMatchers("/leave-application-list/**")
                                                .hasAnyRole("MANAGER", "EMPLOYEE")
                                                .requestMatchers("/h2-console/**", "/login")
                                                .permitAll()
                                                .anyRequest().authenticated())
                                .formLogin((form) -> form
                                                .loginPage("/login")
                                                .defaultSuccessUrl("/", true)
                                                .permitAll())
                                .logout((logout) -> logout.permitAll());
                http.csrf().disable();
                http.headers().frameOptions().disable();
                return http.build();
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

}
