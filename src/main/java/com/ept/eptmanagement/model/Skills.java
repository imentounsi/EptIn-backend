package com.ept.eptmanagement.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Skills {
    @Id
    private Long id;
    private String name;



}
