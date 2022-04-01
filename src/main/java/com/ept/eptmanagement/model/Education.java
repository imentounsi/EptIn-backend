package com.ept.eptmanagement.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
@Data
@Entity
public class Education {
    @Id
    private Long id;
    private String degree;
    private String school;
    private String option;
    private String admissionDate;
    private String graduationDate;
    private String masterField;
    private String pfeField;
    private String phdField;
    private String masterUniversity;
    private String pfeUniversity;
    private String phdUniversity;
    private String comment;




}
