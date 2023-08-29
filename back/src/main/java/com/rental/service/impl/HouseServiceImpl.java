package com.rental.service.impl;

import com.rental.entities.House;
import com.rental.repository.IHouseRepository;
import com.rental.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseServiceImpl implements IHouseService {

    @Autowired
    private IHouseRepository houseRepository;

    @Override
    public House createHouse(House house) {
        return houseRepository.save(house);
    }

    @Override
    public Optional<House> getHouseById(Long id) {
        return houseRepository.findById(id);
    }

    @Override
    public Optional<House> getHouseByHousename(String house) {
        return Optional.empty();
    }

    @Override
    public List<House> getAllHouses() {
        return houseRepository.findAll();
    }

    @Override
    public Optional<House> updateHouse(Long id, House house) {
        if(houseRepository.existsById(id)){
            house.setId(id);
            return Optional.of(houseRepository.save(house));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteHouse(Long id) {
        if(houseRepository.existsById(id)){
            houseRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
