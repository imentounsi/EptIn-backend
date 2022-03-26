package com.ept.eptmanagement.repository;

import com.ept.eptmanagement.model.Offre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OffreRepository extends JpaRepository <Offre,Long> {
    List<Offre> findByType (String type);
//    @Query
//    findBy(String name)
}
