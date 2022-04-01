package com.ept.eptmanagement.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Data
@Entity

public class Experience {
    @Id
    private Long id;
    private String jobTitle;
    private String emloymentType;
    private String companyName;
    private String location;
    private String startDate;
    private String endDate;
    private String description;
    private String city;
    private String country;



    @ManyToMany
    private List<Skills> skills;



}
