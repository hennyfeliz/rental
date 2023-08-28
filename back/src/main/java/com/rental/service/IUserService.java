package com.rental.service;

import com.rental.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User createUser(User user);
    Optional<User> getUserById(Long id);
    Optional<User> getUserByUsername(String username);
    List<User> getAllUsers();
    Optional<User> updateUser(Long id, User user);
    boolean deleteUser(Long id);
    
}
