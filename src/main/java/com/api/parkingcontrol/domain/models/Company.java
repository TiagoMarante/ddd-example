package com.api.parkingcontrol.domain.models;


import javax.persistence.*;

@Entity
@Table(name = "COMPANY")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, unique = false, length = 200)
    private String description;

    @Column(nullable = false, unique = false, length = 200)
    private String country;

    @Column(nullable = false, unique = false, length = 200)
    private String currency;

    @Column(nullable = false, unique = false, length = 200)
    private String status;

}
