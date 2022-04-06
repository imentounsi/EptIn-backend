package com.ept.eptmanagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
public class Offre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exstudent_id")
    @JsonBackReference
    private Exstudent exstudent;

    @ManyToMany
    @JoinTable(name = "Candidature",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "offre_id")}
    )
    @JsonIgnore
    private Set<User> users = new HashSet<User>();

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "Candidature",
//            joinColumns = { @JoinColumn(name = "offre_id") },
//            inverseJoinColumns = { @JoinColumn(name = "student_id")}
//    )
//    private Collection<Student> students =new ArrayList<>();


}
