package com.ept.eptmanagement.repository;

import com.ept.eptmanagement.model.Education;
import com.ept.eptmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {

    List<Education> findByUser(User user);
}
