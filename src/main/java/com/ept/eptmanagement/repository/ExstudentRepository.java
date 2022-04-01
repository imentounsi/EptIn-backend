package com.ept.eptmanagement.repository;

import com.ept.eptmanagement.model.Exstudent;
import com.ept.eptmanagement.model.Offre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExstudentRepository extends JpaRepository<Exstudent, Long> {

}
