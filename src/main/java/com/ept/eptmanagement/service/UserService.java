package com.ept.eptmanagement.service;

import com.ept.eptmanagement.model.Offre;
import com.ept.eptmanagement.model.User;
import com.ept.eptmanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public List<User> getUsers(){
        return userRepository.findAll();
    }
    public List<User> getUserByField(String field){
        return userRepository.findByField(field);
    }
}
