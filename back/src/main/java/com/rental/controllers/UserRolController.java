package com.rental.controllers;

import com.rental.entities.House;
import com.rental.entities.User;
import com.rental.entities.UserRol;
import com.rental.service.impl.UserRolServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<UserRol> getUserRolById(@PathVariable Long id){
        return userRolService.getUserRolById(id)
                .map(userRol -> new ResponseEntity<>(userRol, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping("/")
    public ResponseEntity<UserRol> createUserRol(@RequestBody UserRol userRol){
        return new ResponseEntity<>(userRolService.createUserRol(userRol), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserRol> updateUserRol(@PathVariable Long id, @RequestBody UserRol userRol){
        return userRolService.updateUserRol(id, userRol)
                .map(userRol1 -> new ResponseEntity<>(userRol1, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserRolById(@PathVariable Long id){
        return (userRolService.deleteUserRol(id)) ? ResponseEntity.ok("UserRol deleted.") : new ResponseEntity<>("UserRol not found", HttpStatus.NOT_FOUND);
    }
}
