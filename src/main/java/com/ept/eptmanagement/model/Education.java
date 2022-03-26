package com.ept.eptmanagement.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Data
@Entity
public class Education {
    @Id
    private Long id;
    private String degree;
    private String school;
    private String startdate;
    private String enddate;


}
