package com.ept.eptmanagement.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Data
@Entity
public class Exstudent extends User {
    private String option;//education
    private String photo;
    private String profession; //experience

    private String dateDeNaissance;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "exstudentId")
    private List<Offre> offres = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "exstudentId")
    private List<Experience> experiences = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "exstudentId")
    private List<Certification> certifications = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "exstudentId")
    private List<Education> educations = new ArrayList<>();


}