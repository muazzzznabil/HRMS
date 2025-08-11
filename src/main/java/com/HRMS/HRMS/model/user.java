package com.HRMS.HRMS.model;

import com.HRMS.HRMS.Enums.RoleEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class user {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(unique=true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @NotNull
    private String full_name;


    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    //Todo : Add Department

}
