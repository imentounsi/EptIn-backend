package com.ept.eptmanagement.repository;

import com.ept.eptmanagement.model.Exstudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExstudentRepository extends JpaRepository<Exstudent, Long> {
    Optional<Exstudent> findByEmail(String email);
}
