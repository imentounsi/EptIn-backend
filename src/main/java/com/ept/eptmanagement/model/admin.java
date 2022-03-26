package com.ept.eptmanagement.model;

import lombok.Data;

import javax.persistence.Entity;
@Data
@Entity
public class admin extends User {
    public admin(){}
    public admin(Long id,String email,String firstName,String lastName,String sexe){
        super(id,email,firstName,lastName,sexe);

    }
}
