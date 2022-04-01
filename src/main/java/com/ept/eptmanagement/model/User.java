package com.ept.eptmanagement.model;

import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {
    @Id
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String sexe;
    //private String password;
    //private string phoneNumber
    //private String country
    // private String city;


}
