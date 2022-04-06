package com.ept.eptmanagement.service;

import com.ept.eptmanagement.dto.RegistrationDto;
import com.ept.eptmanagement.model.*;
import com.ept.eptmanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(() -> {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        });

        log.info("user found in the database {}", email);

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().name()));
        return new org.springframework.security.core.userdetails
                .User(user.getEmail(), user.getPassword(), authorities);
    }

    /**
     * Register user
     **/
    public void registerNewUser(RegistrationDto registrationDto) {
        boolean userExists = userRepository
                .findByEmail(registrationDto.getEmail())
                .isPresent();

        if (userExists) {
            throw new IllegalStateException("email already taken");
        }

        switch (registrationDto.getRole()) {
            case "STUDENT":
                Student student = Student.builder()
                        .email(registrationDto.getEmail())
                        .password(passwordEncoder.encode(registrationDto.getPassword()))
                        .firstName(registrationDto.getFirstName())
                        .lastName(registrationDto.getLastName())
                        .role(Role.STUDENT).build();

                userRepository.save(student);
                break;

            case "EX_STUDENT":
                Exstudent exstudent = Exstudent.builder()
                        .email(registrationDto.getEmail())
                        .password(passwordEncoder.encode(registrationDto.getPassword()))
                        .firstName(registrationDto.getFirstName())
                        .lastName(registrationDto.getLastName())
                        .role(Role.EX_STUDENT).build();
                userRepository.save(exstudent);
                break;
            default:
                throw new IllegalStateException("Role not found");
        }
    }

    @Transactional
    public void updateUser(User user) {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (email != null) {
            User usr = userRepository.findByEmail(email).orElseThrow(() -> {
                throw new IllegalStateException("User not found");
            });
            usr.setAddress(user.getAddress());
            usr.setCity(user.getCity());
            usr.setCountry(user.getCountry());
            usr.setBirthday(user.getBirthday());
            usr.setPassword(user.getPassword());
            usr.setFirstName(user.getFirstName());
            usr.setLastName(user.getLastName());
            usr.setGender(user.getGender());
            usr.setPhoneNumber(user.getPhoneNumber());
        }
//        switch (usr.getRole()){
//
//        }





    }
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    /** Get user info **/

}
