package com.ept.eptmanagement.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
    public class OffreStudentId  implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long offreId;
    private Long studentId;
    public OffreStudentId() {

    }

    public OffreStudentId(Long offreId, Long date){
        super();
        this.offreId =offreId ;
        this.studentId=studentId;
    }
    public Long getOffreId() {
        return offreId;
    }

    public void setOffreId(Long candidatureId) {
        this.offreId = offreId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((offreId == null) ? 0 : offreId.hashCode());
        result = prime * result
                + ((studentId == null) ? 0 : studentId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OffreStudentId other = (OffreStudentId) obj;
        return Objects.equals(getOffreId(), other.getOffreId()) && Objects.equals(getStudentId(), other.getStudentId());
    }
}

