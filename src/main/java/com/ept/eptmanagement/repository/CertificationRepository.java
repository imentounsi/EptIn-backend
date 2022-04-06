package com.ept.eptmanagement.repository;

import com.ept.eptmanagement.model.Certification;
import com.ept.eptmanagement.model.Experience;
import com.ept.eptmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificationRepository extends JpaRepository<Certification, Long> {
    List<Certification> findByUser(User user);

}
