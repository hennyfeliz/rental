package com.rental.repository;

import com.rental.entities.RentalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRentalInfoRepository extends JpaRepository<RentalInfo, Long> {
}
