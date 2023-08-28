package com.rental.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "userr")
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    private String name;
    private String lastname;
    private String username;
    private String password;
    private int rol;
}
