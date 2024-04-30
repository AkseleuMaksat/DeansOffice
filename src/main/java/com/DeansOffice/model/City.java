package com.DeansOffice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_city")
@Getter
@Setter
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cityId")
    private int cityId;

    @Column(name = "cityName", length = 100)
    private String cityName;

    @ManyToOne
    @JoinColumn(name = "countryId")
    private Country country;


}
