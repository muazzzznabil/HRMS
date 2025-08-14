package com.HRMS.HRMS.Enums;

public enum LeaveStatusEnum {
    APPROVED("Approved"),
    PENDING("Pending"),
    REJECTED("Rejected"),
    APPEALED("Appealed");

    private final String label;

    LeaveStatusEnum(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

}
