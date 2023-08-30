package com.rental.service.impl;

import com.rental.entities.UserRol;
import com.rental.repository.IUserRolRepository;
import com.rental.service.IUserRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRolServiceImpl implements IUserRolService {

    @Autowired
    private IUserRolRepository userRolRepository;


    @Override
    public UserRol createUserRol(UserRol userRol) {
        return userRolRepository.save(userRol);
    }

    @Override
    public Optional<UserRol> getUserRolById(Long id) {
        return userRolRepository.findById(id);
    }

    @Override
    public List<UserRol> getAllUsersRol() {
        return userRolRepository.findAll();
    }

    @Override
    public Optional<UserRol> updateUserRol(Long id, UserRol userRol) {
        if(userRolRepository.existsById(id)){
            userRol.setId(id);
            return Optional.of(userRolRepository.save(userRol));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteUserRol(Long id) {
        if(userRolRepository.existsById(id)){
            userRolRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
