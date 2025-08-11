package com.HRMS.HRMS.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

@Entity
public class user {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_id;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String full_name;

    // @OneToMany
    // private leave_application leave_app;

}
