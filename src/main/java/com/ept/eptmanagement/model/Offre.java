package com.ept.eptmanagement.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Offre {
    @Id
    private Long id;
    private String name;
    private String authority ;
    private String field ;
    private String email;
    private String phoneNumber;
    private String country;
    private String city;
    private String type;
    private String comment;
    private String startDate;
    private String endDate;





    @ManyToMany
    @JoinTable(name = "Candidature",
            joinColumns = { @JoinColumn(name = "student_id") },
            inverseJoinColumns = { @JoinColumn(name = "offre_id")}
    )
    private Set<Student> students = new HashSet<Student>();




}
