package com.ept.eptmanagement.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Data
@Entity

public class Certification {
    @Id
    private Long id;
    private String name;
    private String authority;
    private String issueDate;
    private String expirationDate;




}
