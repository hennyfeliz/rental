package com.rental.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rental_info")
public class RentalInfo {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    private double price;
    @Column(name = "rental_or_sale")
    private String rentalOrSale;
    @Column(name = "publish_date_start")
    private String publishDateStart;
    @Column(name = "publish_date_finish")
    private String publishDateFinish;

    @OneToMany(mappedBy = "rentalInfo")
    private List<House> houses;

}
