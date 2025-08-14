package com.HRMS.HRMS.model;

import java.time.LocalDate;

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

    @NotNull
    private String reason;

    @Nullable
    private String reject_reason;

    @Nullable
    private String appeal_reason;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private user employee_user;


    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public LeaveStatusEnum getApplication_status() {
        return application_status;
    }

    public void setApplication_status(LeaveStatusEnum application_status) {
        this.application_status = application_status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReject_reason() {
        return reject_reason;
    }

    public void setReject_reason(String reject_reason) {
        this.reject_reason = reject_reason;
    }

    public String getAppeal_reason() {
        return appeal_reason;
    }

    public void setAppeal_reason(String appeal_reason) {
        this.appeal_reason = appeal_reason;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate starDate) {
        this.startDate = starDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public user getEmployee_user() {
        return employee_user;
    }

    public void setEmployee_user(user employee_user) {
        this.employee_user = employee_user;
    }

  

    



}
