package com.api.parkingcontrol.init.models.Company;


import javax.persistence.*;

@Entity
@Table(name = "COMPANY")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = false, length = 200)
    private String description;

    @Column(nullable = false, unique = false, length = 200)
    private String country;

    @Column(nullable = false, unique = false, length = 200)
    private String currency;

    @Column(nullable = false, unique = false, length = 200)
    private String status;

}
