package com.HRMS.HRMS.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import com.HRMS.HRMS.Enums.RoleEnum;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

@Entity
@Table(name = "users")
public class user {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    @NotNull
    private String full_name;

    @Nullable
    private LocalDate last_loggedIn_Date;

    @Nullable
    private long last_loggedIn_Day;

    @Nullable
    @ManyToOne
    private Department department;

    public LocalDate getLast_loggedIn_Date() {
        return last_loggedIn_Date;
    }

    public void setLast_loggedIn_Date(LocalDate last_loggedIn_Date) {
        this.last_loggedIn_Date = last_loggedIn_Date;
    }

    public long getLast_loggedIn_Day() {
        return last_loggedIn_Day;
    }

    public void setLast_loggedIn_Day(long last_loggedIn_Day) {
        this.last_loggedIn_Day = last_loggedIn_Day;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

}
