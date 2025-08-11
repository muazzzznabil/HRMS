package com.HRMS.HRMS.model;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.cglib.core.Local;

import com.HRMS.HRMS.Enums.LeaveStatusEnum;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class leave_application {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId;

    @NotNull
    private LeaveStatusEnum application_status;

    @Nullable
    private String reject_reason;

    @Nullable
    private String appeal_reason;
    
    @NotNull
    private Date application_date;

    @NotNull
    private LocalDate starDate;
    
    @NotNull
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private user employee;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private user manager;



}
