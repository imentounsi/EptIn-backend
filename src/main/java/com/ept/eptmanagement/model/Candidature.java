package com.ept.eptmanagement.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Candidature {

    @EmbeddedId
    private OffreStudentId id = new OffreStudentId();

    @ManyToOne
    @MapsId("offreId")
    private Offre offre;

    @ManyToOne
    @MapsId("userId")
    private User user;

    private Date date;
}








