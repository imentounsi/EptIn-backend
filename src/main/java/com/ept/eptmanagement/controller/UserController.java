package com.ept.eptmanagement.controller;

import com.ept.eptmanagement.model.Offre;
import com.ept.eptmanagement.model.User;
import com.ept.eptmanagement.service.OffreService;
import com.ept.eptmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<?> getUsers() {
        List<User> users = userService.getUsers();
        return new ResponseEntity(users, HttpStatus.OK);
    }
    @GetMapping("/{field}")
    public ResponseEntity<?> getUserByField(@PathVariable String field) {
        List<User> users = userService.getUserByField(field);
        return new ResponseEntity(users, HttpStatus.OK);
    }

}
