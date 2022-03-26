package com.ept.eptmanagement.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Data
class Candidature {

    @EmbeddedId
    private OffreStudentId id = new OffreStudentId();

    @ManyToOne
    @MapsId("offreId")
    private Offre offre;

    @ManyToOne
    @MapsId("studentId")
    private Student student;

    private String date;
}








