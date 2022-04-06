package com.ept.eptmanagement.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
public class Student extends User {
    private String option; //education

//    @ManyToMany(mappedBy="student" , cascade = CascadeType.ALL)
//    private Collection<Offre> offres =new ArrayList<>();

}
