package com.ept.eptmanagement.repository;

import com.ept.eptmanagement.model.Education;
import com.ept.eptmanagement.model.Experience;
import com.ept.eptmanagement.model.Exstudent;
import com.ept.eptmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {
    List<Experience> findByUser(User user);
}
