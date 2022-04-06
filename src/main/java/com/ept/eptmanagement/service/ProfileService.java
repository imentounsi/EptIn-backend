package com.ept.eptmanagement.service;

import com.ept.eptmanagement.model.*;
import com.ept.eptmanagement.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final UserRepository userRepository;
    private final ExperienceRepository experienceRepository;
    private final EducationRepository educationRepository;
    private final CertificationRepository certificationRepository;



    public void saveNewExperience(Experience experience) {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (email != null) {
            User user = userRepository.findByEmail(email).orElseThrow(() -> {
                throw new IllegalStateException("User not found");
            });
            experience.setUser(user);
            experienceRepository.save(experience);

        }
    }

    public void saveNewEducation(Education education) {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (email != null) {
            User user = userRepository.findByEmail(email).orElseThrow(() -> {
                throw new IllegalStateException("User not found");
            });
            education.setUser(user);
            educationRepository.save(education);

        }
    }

    public void saveNewCertification(Certification certification) {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (email != null) {
            User user = userRepository.findByEmail(email).orElseThrow(() -> {
                throw new IllegalStateException("User not found");
            });
            certification.setUser(user);
            certificationRepository.save(certification);

        }
    }


    public List<Education> getEducationByUser() {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (email != null) {
            User usr = userRepository.findByEmail(email).orElseThrow(() -> {
                throw new IllegalStateException("User not found");
            });
            return usr.getEducation();

        }
        return null;
          }

    public List<Experience> getExperienceByUser() {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (email != null) {
            User usr = userRepository.findByEmail(email).orElseThrow(() -> {
                throw new IllegalStateException("User not found");
            });
            return usr.getExperience();

        }
        return null;


    }

    public List<Certification> getCertificationByUser() {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (email != null) {
            User usr = userRepository.findByEmail(email).orElseThrow(() -> {
                throw new IllegalStateException("User not found");
            });
            return usr.getCertification();

        }
        return null;
    }

    @Transactional //pour eviter save//en cas de probleme rollback
    public void updateEducation(Education education) {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (email != null) {
            User usr = userRepository.findByEmail(email).orElseThrow(() -> {
                throw new IllegalStateException("User not found");
            });
            Education edc = educationRepository.findById(education.getId())
                    .orElseThrow(() -> new IllegalStateException("education not exist"));
            edc.setOption(education.getOption());
            edc.setAdmissionDate(education.getAdmissionDate());
            edc.setGraduationDate(education.getGraduationDate());
            edc.setMasterField(education.getMasterField());
            edc.setPfeField(education.getPfeField());
            edc.setPhdField(education.getPhdField());
            edc.setMasterUniversity(education.getMasterUniversity());
            edc.setPfeUniversity(education.getPfeUniversity());
            edc.setPhdUniversity(education.getPhdUniversity());
            edc.setComment(education.getComment());
        }





    }




    public List<Education> getEducationByUser(User user) {return educationRepository.findByUser(user);
    }
    public List<Experience> getExperienceByUser(User user) {return experienceRepository.findByUser(user);
    }
    public List<Certification> getCertificationByUser(User user) {return certificationRepository.findByUser(user);
    }
}




