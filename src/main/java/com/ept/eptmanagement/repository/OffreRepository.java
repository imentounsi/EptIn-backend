package com.ept.eptmanagement.repository;

import com.ept.eptmanagement.model.Experience;
import com.ept.eptmanagement.model.Exstudent;
import com.ept.eptmanagement.model.Offre;
import com.ept.eptmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OffreRepository extends JpaRepository <Offre,Long> {
    List<Offre> findByType (String type);
    List<Offre> findByField (String field);
    List<Offre> findByExstudent(Exstudent exstudent);

//    @Query
//    findBy(String name)
}

