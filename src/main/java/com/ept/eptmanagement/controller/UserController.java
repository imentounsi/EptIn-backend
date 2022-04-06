package com.ept.eptmanagement.controller;

import com.ept.eptmanagement.dto.RegistrationDto;
import com.ept.eptmanagement.model.Offre;
import com.ept.eptmanagement.model.User;
import com.ept.eptmanagement.repository.UserRepository;
import com.ept.eptmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("users")
@Controller
@CrossOrigin("http://localhost:4200")

public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    /**
     * Register new user
     **/
    @PostMapping
    public ResponseEntity registerNewUser(@RequestBody RegistrationDto registrationDto) {
        userService.registerNewUser(registrationDto);
        return ResponseEntity.ok().build();
    }

    /**
     * Get user information
     **/
    @GetMapping(value = "/me")
    public ResponseEntity<User> getUserByIds(Authentication auth) {
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString().equals("anonymousUser")) {
            return null;
        }
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (email == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        User user = userRepository.findByEmail(email).orElseThrow(() -> {
            throw new IllegalStateException("User not found");
        });
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userRepository.findById(id).orElse(null);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateUser(@RequestBody User user){
        userService.updateUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping//("/test") path
    public ResponseEntity<?> getUsers() {
        List<User> users = userService.getUsers();
        return new ResponseEntity(users, HttpStatus.OK);
    }
}
