package com.ept.eptmanagement.service;

import com.ept.eptmanagement.Mapper.OfferMapper;
import com.ept.eptmanagement.dto.OffreDto;
import com.ept.eptmanagement.model.Candidature;
import com.ept.eptmanagement.model.Exstudent;
import com.ept.eptmanagement.model.Offre;
import com.ept.eptmanagement.model.User;
import com.ept.eptmanagement.repository.CandidatureRepository;
import com.ept.eptmanagement.repository.ExstudentRepository;
import com.ept.eptmanagement.repository.OffreRepository;
import com.ept.eptmanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OffreService {
    private final OffreRepository offreRepository;
    private final ExstudentRepository exstudentRepository;
    private final UserRepository userRepository;
    private final CandidatureRepository candidatureRepository;


    private static final OfferMapper OFFER_MAPPER = OfferMapper.INSTANCE;


    public void addNewOffre(OffreDto offreDto) {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (email != null) {
            Exstudent exstudent = exstudentRepository.findByEmail(email).orElseThrow(() -> {
                throw new IllegalStateException("User not found");
            });
            Offre offre = OFFER_MAPPER.toEntity(offreDto);
            offre.setExstudent(exstudent);
            offreRepository.save(offre);
        }
    }

    public List<Offre> getOffers() {
        return offreRepository.findAll();
    }

    public List<Offre> getOffreByType(String type) {
        return offreRepository.findByType(type);
    }

    public List<Offre> getOffreByField(String field) {
        return offreRepository.findByField(field);
    }


    @Transactional //pour eviter save//en cas de probleme rollback
    public void updateOffre(Offre offre) {
        Offre ofr = offreRepository.findById(offre.getId())
                .orElseThrow(() -> new IllegalStateException("offre not exist"));
        ofr.setAuthority(offre.getAuthority());
        ofr.setCity(offre.getCity());
        ofr.setCountry(offre.getCountry());
        ofr.setId(offre.getId());
        ofr.setName(offre.getName());
        ofr.setType(offre.getType());
    }

    public void deleteOffre(Long id) {
        Offre ofr = offreRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("offre not exist"));
        offreRepository.delete(ofr);

    }

    public List<Offre> getOffreByExstudent(Exstudent exstudent) {
        return offreRepository.findByExstudent(exstudent);
    }

    public Optional<Offre> getOffreById(Long id) {
        return offreRepository.findById(id);
    }

    public void applyToOffre(Long offreId) {
        Offre offre = offreRepository.findById(offreId)
                .orElseThrow(() -> new IllegalStateException("offre not exist"));
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (email != null) {
            User user = userRepository.findByEmail(email).orElseThrow(() -> {
                throw new IllegalStateException("User not found");
            });
            Candidature candidature = new Candidature();
            candidature.setOffre(offre);
            candidature.setUser(user);
            candidature.setDate(new Date());
            candidatureRepository.save(candidature);


        }
    }

    public List<Offre> getCandidatures(){
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (email != null) {
            User user = userRepository.findByEmail(email).orElseThrow(() -> {
                throw new IllegalStateException("User not found");
            });
            List<Offre> offres=new ArrayList<>();
            List <Candidature> candidatures=candidatureRepository.findByUser(user);
            candidatures.stream().forEach(candidature -> {
                offres.add(candidature.getOffre());
            });
            return offres;
        }
        return null;

    }

}

