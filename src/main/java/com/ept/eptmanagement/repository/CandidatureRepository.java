package com.ept.eptmanagement.repository;

import com.ept.eptmanagement.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidatureRepository extends JpaRepository<Candidature, OffreStudentId > {
    List<Candidature> findByUser(User user);
}
