package com.rental.controllers;

import com.rental.entities.House;
import com.rental.service.impl.HouseServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<House> getHouseById(@PathVariable Long id){
        return houseService.getHouseById(id)
                .map(house -> new ResponseEntity<>(house, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping("/")
    public ResponseEntity<House> createHouse(@RequestBody House house){
        return new ResponseEntity<>(houseService.createHouse(house), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<House> updateHouse(@PathVariable Long id, @RequestBody House house){
        return houseService.updateHouse(id, house)
                .map(house1 -> new ResponseEntity<>(house1, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHouseById(@PathVariable Long id){
        return (houseService.deleteHouse(id)) ? ResponseEntity.ok("House deleted.") : new ResponseEntity<>("House not found", HttpStatus.NOT_FOUND);
    }


}
