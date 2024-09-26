package org.choucair.models;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
public class Candidate {

    private String username;

    private String password;

    private String firstName;

    private String middleName;

    private String lastName;

    private String vacancy;

    private String email;

    private String phone;

    private String cv;

    private String keywords;

    private String notes;

    private String tittleInterview;

    private String interviewer;
}
