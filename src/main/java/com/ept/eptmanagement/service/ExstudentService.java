package com.ept.eptmanagement.service;

import com.ept.eptmanagement.model.Exstudent;
import com.ept.eptmanagement.repository.ExstudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ExstudentService {
    private final ExstudentRepository exstudentRepository;

//    public void addNewExstudent(Exstudent exstudent){
//        exstudentRepository.save(exstudent);
//    }


    public  List<Exstudent> getExstudents() {return exstudentRepository.findAll();}

//    public List<Exstudent> getExstudentById(Long id){ return exstudentRepository.findById(id);}


}
