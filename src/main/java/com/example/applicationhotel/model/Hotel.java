package com.example.applicationhotel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Hotel {
    @Id
    private Integer id_hotel;
    private String name;
    private String address;
    @ManyToOne
    @JoinColumn(name = "id_city")
    private City city;

    public Hotel( String name, String address, City city ){
        this.name = name;
        this.address = address;
        this.city=city;
    }
    public Hotel() {

    }
}
