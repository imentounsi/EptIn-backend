package com.ept.eptmanagement.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
    public class OffreStudentId  implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long offreId;
    private Long userId;
    public OffreStudentId() {

    }

    public OffreStudentId(Long offreId, Long date){
        super();
        this.offreId =offreId ;
        this.userId=userId;
    }
    public Long getOffreId() {
        return offreId;
    }

    public void setOffreId(Long candidatureId) {
        this.offreId = offreId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setStudentId(Long userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((offreId == null) ? 0 : offreId.hashCode());
        result = prime * result
                + ((userId == null) ? 0 : userId.hashCode());
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
        return Objects.equals(getOffreId(), other.getOffreId()) && Objects.equals(getUserId(), other.getUserId());
    }
}

