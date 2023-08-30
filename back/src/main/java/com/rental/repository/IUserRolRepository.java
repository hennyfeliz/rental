package com.rental.repository;

import com.rental.entities.UserRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRolRepository extends JpaRepository<UserRol, Long> {
}
