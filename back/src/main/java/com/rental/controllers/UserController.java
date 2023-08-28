package com.rental.controllers;

import com.rental.entities.User;
import com.rental.service.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
