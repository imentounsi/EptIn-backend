//package com.ept.eptmanagement.controller;
//
////import com.ept.eptmanagement.model.Skills;
//import com.ept.eptmanagement.service.SkillsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("skill")
//public class SkillsController {
//    @Autowired
//    private SkillsService skillsService;
//    @PostMapping
//    public ResponseEntity addNewSkill(@RequestBody Skills skill){
//        skillsService.addNewSkill(skill);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//}
