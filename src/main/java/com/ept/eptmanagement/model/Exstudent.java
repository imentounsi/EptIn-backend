package com.ept.eptmanagement.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Data
@Entity
public class Exstudent extends User {
    private String option;
    private String photo;
    private String profession;
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

    public Exstudent() {
    }

    public Exstudent(Long id, String email, String firstName, String lastName,String sexe, String option, String photo, String profession,String dateDeNaissance) {
        super(id, email, firstName, lastName,sexe);
        this.option = option;
        this.photo = photo;
        this.profession = profession;
        this.dateDeNaissance=dateDeNaissance;


    }
}