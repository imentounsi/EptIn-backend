package com.ept.eptmanagement.dto;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class RegistrationDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;
    private String birthDate;
    private String city;
    private String country;
    private String address;
    private String phone;
}
