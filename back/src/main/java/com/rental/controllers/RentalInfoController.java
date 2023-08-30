package com.rental.controllers;

import com.rental.entities.RentalInfo;
import com.rental.service.impl.RentalInfoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rentalInfo")
public class RentalInfoController {

    private final RentalInfoServiceImpl rentalInfoService;

    public RentalInfoController(RentalInfoServiceImpl rentalInfoService) {
        this.rentalInfoService = rentalInfoService;
    }

    @GetMapping("/")
    public ResponseEntity<List<RentalInfo>> getAllRentalInfos(){
        return new ResponseEntity<>(rentalInfoService.getAllRentalInfos(), HttpStatus.OK);
    }
}
