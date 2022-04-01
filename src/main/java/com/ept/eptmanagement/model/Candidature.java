package com.ept.eptmanagement.model;


import lombok.Data;

import javax.persistence.*;

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








