package com.rental.controllers;

import com.rental.entities.House;
import com.rental.entities.RentalInfo;
import com.rental.service.impl.RentalInfoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<RentalInfo> getRentalInfoById(@PathVariable Long id){
        return rentalInfoService.getRentalInfoById(id)
                .map(rentalInfo -> new ResponseEntity<>(rentalInfo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping("/")
    public ResponseEntity<RentalInfo> createRentalInfo(@RequestBody RentalInfo rentalInfo){
        return new ResponseEntity<>(rentalInfoService.createRentalInfo(rentalInfo), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RentalInfo> updateRentalInfo(@PathVariable Long id, @RequestBody RentalInfo rentalInfo){
        return rentalInfoService.updateRentalInfo(id, rentalInfo)
                .map(rentalInfo1 -> new ResponseEntity<>(rentalInfo1, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRentalInfoById(@PathVariable Long id){
        return (rentalInfoService.deleteRentalInfo(id)) ? ResponseEntity.ok("RentalInfo deleted.") : new ResponseEntity<>("RentalInfo not found", HttpStatus.NOT_FOUND);
    }
}
