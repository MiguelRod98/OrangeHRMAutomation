package org.choucair.models;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
public class Employee {

    private String username;
    private String password;
    private String firstName;
    private String middleName;
    private String lastName;
    private String employeeId;
    private String createLoginDetails;
    private String userPassword;
    private String confirmPassword;
    private String status;
}