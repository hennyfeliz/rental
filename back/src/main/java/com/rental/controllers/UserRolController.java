package com.rental.controllers;

import com.rental.entities.User;
import com.rental.entities.UserRol;
import com.rental.service.impl.UserRolServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/userrol")
public class UserRolController {

    private final UserRolServiceImpl userRolService;

    public UserRolController(UserRolServiceImpl userService) {
        this.userRolService = userService;
    }


    @GetMapping("/")
    public ResponseEntity<List<UserRol>> getAllUsers(){
        return new ResponseEntity<>(userRolService.getAllUsersRol(), HttpStatus.OK);
    }
}
