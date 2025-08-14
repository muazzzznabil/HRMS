package com.HRMS.HRMS.Enums;

public enum RoleEnum {
    ROLE_ADMIN("Admin"),
    ROLE_MANAGER("Manager"),
    ROLE_EMPLOYEE("Employee");

    private final String label;

    RoleEnum(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
