package com.HRMS.HRMS.libs;

public class roleName {
    
    public static String RoleName(String Role){

        switch (Role) {
            case "ROLE_ADMIN":
                return "Admin";
            case "ROLE_EMPLOYEE":
                return "Employee";
            case "ROLE_MANAGER":
                return "Manager";
        }
        return "Not Assigned";
    }

}
