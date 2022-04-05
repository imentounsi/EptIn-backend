package com.ept.eptmanagement.controller;

import com.ept.eptmanagement.dto.OffreDto;
import com.ept.eptmanagement.model.*;
import com.ept.eptmanagement.service.ExstudentService;
import com.ept.eptmanagement.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("profile")
@RequiredArgsConstructor

public class ProfileController {
    private final ProfileService profileService;

    @PostMapping("experience")
    public ResponseEntity addNewExperience(@RequestBody Experience experience) {
        profileService.saveNewExperience(experience);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/education")
    public ResponseEntity addNewEducation(@RequestBody Education education) {
        profileService.saveNewEducation(education);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/certification")
    public ResponseEntity addNewCertification(@RequestBody Certification certification) {
        profileService.saveNewCertification(certification);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/education")
    public ResponseEntity<?> getEducationByUser() {
        List<Education> education = profileService.getEducationByUser();
        return new ResponseEntity(education, HttpStatus.OK);
    }

    @GetMapping("/experience")
    public ResponseEntity<?> getExperienceByUser() {
        List<Experience> experience = profileService.getExperienceByUser();
        return new ResponseEntity(experience, HttpStatus.OK);
    }

    @GetMapping("/certification")
    public ResponseEntity<?> getCertificationByUser() {
        List<Certification> certification = profileService.getCertificationByUser();
        return new ResponseEntity(certification, HttpStatus.OK);
    }

    @PutMapping("/education")
    public ResponseEntity updateEducation(@RequestBody Education education){
        profileService.updateEducation(education);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
