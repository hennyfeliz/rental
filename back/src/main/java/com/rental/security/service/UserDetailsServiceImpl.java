package com.rental.security.service;

import java.util.List;
import java.util.Optional;

//import com.security.application.service.UserService;
//import com.security.domain.model.User;
import com.rental.entities.User;
import com.rental.service.impl.UserServiceImpl;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserServiceImpl userService;

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    public UserDetailsServiceImpl(UserServiceImpl usuarioService) {
        this.userService = usuarioService;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = gettingUser(username);
        //Optional<User> User = UserService.getUserByUsername(username);

        logger.info("Datos del User {}", user);


        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password(hashPassword(user.getPassword()))
                .roles("ADMIN")
                .build();
    }

    //public record User(String username, String password, Set<String> roles) {};

    public User gettingUser(String username) {
        // Optional<User> user = userService.getUserByEmail(email);
        // logger.info("username: {}, password: {}", user1.getEmail(), user1.getPassword());
        Optional<User> user = userService.getUserByUsername(username);
        if(user.isPresent()){
            return user.get();
        } else{
            return null;
        }
    }

    // Método para generar un hash BCrypt a partir de una contraseña
    public static String hashPassword(String password) {
        String salt = BCrypt.gensalt(); // Generar un salt aleatorio
        return BCrypt.hashpw(password, salt); // Generar el hash BCrypt
    }

    // Método para verificar si una contraseña coincide con un hash BCrypt
    public static boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}