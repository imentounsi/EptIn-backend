package com.ept.eptmanagement.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;



}
