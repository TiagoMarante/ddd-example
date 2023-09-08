package com.api.parkingcontrol.models.Company;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "COMPANY")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Company implements Serializable {

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
