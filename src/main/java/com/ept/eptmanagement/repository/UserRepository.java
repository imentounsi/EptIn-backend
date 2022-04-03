package com.ept.eptmanagement.repository;


import com.ept.eptmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByField (String field);
}
