package com.ept.eptmanagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;
}
