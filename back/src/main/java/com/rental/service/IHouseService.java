package com.rental.service;

import com.rental.entities.House;

import java.util.List;
import java.util.Optional;

public interface IHouseService {
    House createHouse(House house);
    Optional<House> getHouseById(Long id);
    Optional<House> getHouseByHousename(String house);
    List<House> getAllHouses();
    Optional<House> updateHouse(Long id, House house);
    boolean deleteHouse(Long id);

}
