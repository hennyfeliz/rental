package com.rental.controllers;

import com.rental.entities.House;
import com.rental.service.impl.HouseServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/houses")
public class HouseController {

    private final HouseServiceImpl houseService;

    public HouseController(HouseServiceImpl houseService) {
        this.houseService = houseService;
    }

    @GetMapping("/")
    public ResponseEntity<List<House>> getAllHouses(){
        return new ResponseEntity<>(houseService.getAllHouses(), HttpStatus.OK);
    }
}
