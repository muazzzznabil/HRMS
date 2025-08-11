package com.HRMS.HRMS.model;

import java.sql.Date;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class leave_application {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String applicationId;

    @NotNull
    private Boolean application_status;

    @Nullable
    private String reject_reason;

    @Nullable
    private String appeal_reason;
    
    @NotNull
    private Date application_date;

    // @ManyToOne
    // private user employee;


}
