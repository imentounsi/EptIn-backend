package com.ept.eptmanagement.controller;

import com.ept.eptmanagement.model.Exstudent;
import com.ept.eptmanagement.model.Offre;
import com.ept.eptmanagement.service.ExstudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("exstudents")
@RequiredArgsConstructor
public class ExstudentController {

    private final ExstudentService exstudentService;

    @GetMapping//("/test") path
    public ResponseEntity<?> getExstudents() {
        List<Exstudent> exstudents = exstudentService.getExstudents();
        return new ResponseEntity(exstudents, HttpStatus.OK);
//    @PostMapping
//    public ResponseEntity addNewExstudent(@RequestBody Exstudent exstudent) {
//        exstudentService.addNewExstudent(exstudent);
//        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<?> getExstudentById(@PathVariable Long id) {
//        List<Exstudent> exstudents = exstudentService.getExstudentById(id);
//        return new ResponseEntity(exstudents, HttpStatus.OK);
//    }
}
