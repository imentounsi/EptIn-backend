package com.ept.eptmanagement.controller;

import com.ept.eptmanagement.dto.OffreDto;
import com.ept.eptmanagement.model.Candidature;
import com.ept.eptmanagement.model.Exstudent;
import com.ept.eptmanagement.model.Offre;
import com.ept.eptmanagement.model.User;
import com.ept.eptmanagement.repository.ExstudentRepository;
import com.ept.eptmanagement.service.OffreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("offres")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")

public class OffreController {
    private final OffreService offreService;
    private final ExstudentRepository exstudentRepository;


    @GetMapping//("/test") path
    public ResponseEntity<?> getOffres() {
        List<Offre> offres = offreService.getOffers();
        return new ResponseEntity(offres, HttpStatus.OK);
    }

    //pathvariable
    @GetMapping("/type/{type}")
    public ResponseEntity<?> getOffreByType(@PathVariable String type) {
        List<Offre> offres = offreService.getOffreByType(type);
        return new ResponseEntity(offres, HttpStatus.OK);
    }

    @GetMapping("/field/{field}")
    public ResponseEntity<?> getOffreByField(@PathVariable String field) {
        List<Offre> offres = offreService.getOffreByField(field);
        return new ResponseEntity(offres, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addNewOffre(@RequestBody OffreDto offre) {
        // todo get logged in user
        offreService.addNewOffre(offre);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateOffre(@RequestBody Offre offre){
        offreService.updateOffre(offre);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOffre(@PathVariable Long id){
        offreService.deleteOffre(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/exstudent/{id}")
    public ResponseEntity<?> getOffreByExstudentId(@PathVariable Long id) {
        Exstudent exstudent = exstudentRepository.findById(id).orElse(null);
        List<Offre> offre = offreService.getOffreByExstudent(exstudent);
        return new ResponseEntity(offre, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getOffreById(@PathVariable Long id) {
        Optional<Offre> offre = offreService.getOffreById(id);
        return new ResponseEntity(offre, HttpStatus.OK);
    }

    @PostMapping("/apply")
    public ResponseEntity applyToOffre(@RequestBody String id) {
        offreService.applyToOffre(Long.valueOf(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/candidatures")
    public  ResponseEntity getCandidatures() {
        List<Offre> offres= offreService.getCandidatures();
        return new ResponseEntity<>(offres,HttpStatus.OK);
    }



}
