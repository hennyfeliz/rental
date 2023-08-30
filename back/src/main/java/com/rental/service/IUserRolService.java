package com.rental.service;

import com.rental.entities.UserRol;

import java.util.List;
import java.util.Optional;

public interface IUserRolService {
    UserRol createUserRol(UserRol user);
    Optional<UserRol> getUserRolById(Long id);
    List<UserRol> getAllUsersRol();
    Optional<UserRol> updateUserRol(Long id, UserRol user);
    boolean deleteUserRol(Long id);
}
