package com.ept.eptmanagement.repository;

import com.ept.eptmanagement.model.Experience;
import com.ept.eptmanagement.model.Exstudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}
