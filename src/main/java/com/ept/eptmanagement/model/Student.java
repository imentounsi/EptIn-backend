package com.ept.eptmanagement.model;

import lombok.Data;

import javax.persistence.Entity;


@Data
@Entity
public class Student extends User {
    private String option;
    private String photo;
    private String dateDeNaissance;



    public Student(){}
    public Student(Long id,String email,String firstName,String lastName,String sexe,String option,String photo,String dateDeNaissance){
        super(id,email,firstName,lastName,sexe);
        this.option=option;
        this.photo=photo;
        this.dateDeNaissance=dateDeNaissance;

    }
}
