package com.rental.service.impl;

import com.rental.entities.RentalInfo;
import com.rental.repository.IRentalInfoRepository;
import com.rental.service.IRentalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentalInfoServiceImpl implements IRentalInfoService {

    @Autowired
    private IRentalInfoRepository rentalInfoRepository;

    @Override
    public RentalInfo createRentalInfo(RentalInfo rentalInfo) {
        return rentalInfoRepository.save(rentalInfo);
    }

    @Override
    public Optional<RentalInfo> getRentalInfoById(Long id) {
        return rentalInfoRepository.findById(id);
    }

    @Override
    public Optional<RentalInfo> getRentalInfoByRentalInfoname(String rentalInfo) {
        return Optional.empty();
    }

    @Override
    public List<RentalInfo> getAllRentalInfos() {
        return rentalInfoRepository.findAll();
    }

    @Override
    public Optional<RentalInfo> updateRentalInfo(Long id, RentalInfo rentalInfo) {
        if(rentalInfoRepository.existsById(id)){
            rentalInfo.setId(id);
            return Optional.of(rentalInfoRepository.save(rentalInfo));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteRentalInfo(Long id) {
        if(rentalInfoRepository.existsById(id)){
            rentalInfoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
