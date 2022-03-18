package com.ept.eptmanagement.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data

public class User {
    @Id
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
}
