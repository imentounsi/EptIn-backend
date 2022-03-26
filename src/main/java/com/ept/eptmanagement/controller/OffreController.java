package com.ept.eptmanagement.controller;

import com.ept.eptmanagement.model.Offre;
import com.ept.eptmanagement.service.OffreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("offres")
@RequiredArgsConstructor
public class OffreController {
    private final OffreService offreService;

    @GetMapping//("/test") path
    public ResponseEntity<?> getOffres() {
        List<Offre> offres = offreService.getOffers();
        return new ResponseEntity(offres, HttpStatus.OK);
    }

    //pathvariable
    @GetMapping("/{type}")
    public ResponseEntity<?> getOffreByType(@PathVariable String type) {
        List<Offre> offres = offreService.getOffreByType(type);
        return new ResponseEntity(offres, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addNewOffre(@RequestBody Offre offre) {
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


}
