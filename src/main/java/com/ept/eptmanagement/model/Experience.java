package com.ept.eptmanagement.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Data
@Entity

public class Experience {
    @Id
    private Long id;
    private String title;
    private String emloymentType;
    private String companyName;
    private String location;
    private String startDate;
    private String endDate;
    private String description;


    @ManyToMany
    private List<Skills> skills;



}
