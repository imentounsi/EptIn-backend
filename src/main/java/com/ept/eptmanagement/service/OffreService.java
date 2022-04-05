package com.ept.eptmanagement.service;

import com.ept.eptmanagement.Mapper.OfferMapper;
import com.ept.eptmanagement.dto.OffreDto;
import com.ept.eptmanagement.model.Exstudent;
import com.ept.eptmanagement.model.Offre;
import com.ept.eptmanagement.repository.ExstudentRepository;
import com.ept.eptmanagement.repository.OffreRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OffreService {
    private final OffreRepository offreRepository;
    private final ExstudentRepository exstudentRepository;
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
}
