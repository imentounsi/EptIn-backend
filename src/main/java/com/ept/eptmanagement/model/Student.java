package com.ept.eptmanagement.model;

import lombok.Data;

import javax.persistence.Entity;


@Data
@Entity
public class Student extends User {
    private String option; //education
    private String photo;
    private String dateDeNaissance;




}
