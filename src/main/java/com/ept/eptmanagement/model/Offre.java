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
    private String country;
    private String city;
    private String type;


    @ManyToMany
    @JoinTable(name = "Candidature",
            joinColumns = { @JoinColumn(name = "student_id") },
            inverseJoinColumns = { @JoinColumn(name = "offre_id")}
    )
    private Set<Student> students = new HashSet<Student>();


    public Offre(){}
    public Offre(Long id,String name,String authority,String country,String city,String type){
        this.id=id;
        this.name=name;
        this.authority=authority;
        this.country=country;
        this.city=city;
        this.type=type;
    }

}
