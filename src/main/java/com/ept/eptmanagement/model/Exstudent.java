package com.ept.eptmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
public class Exstudent extends User {
    private String option;//education
    private String profession; //experience

    @OneToMany(mappedBy = "exstudent",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Offre> offres = new ArrayList<>();






}