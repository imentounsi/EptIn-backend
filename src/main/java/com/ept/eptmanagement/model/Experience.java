package com.ept.eptmanagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Data
@Entity

public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;



}
