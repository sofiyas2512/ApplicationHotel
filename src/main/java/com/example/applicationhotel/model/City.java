package com.example.applicationhotel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class City {
    @Id
    private Integer idCity;
    @Column(name = "name")
    private String name_city;
    @OneToMany(mappedBy = "city")
    private List<Hotel> hotels;
}
