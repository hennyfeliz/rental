package com.rental.service;

import com.rental.entities.RentalInfo;

import java.util.List;
import java.util.Optional;

public interface IRentalInfoService {
    RentalInfo createRentalInfo(RentalInfo rentalInfo);
    Optional<RentalInfo> getRentalInfoById(Long id);
    Optional<RentalInfo> getRentalInfoByRentalInfoname(String rentalInfo);
    List<RentalInfo> getAllRentalInfos();
    Optional<RentalInfo> updateRentalInfo(Long id, RentalInfo rentalInfo);
    boolean deleteRentalInfo(Long id);

}
