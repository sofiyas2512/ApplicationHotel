package com.example.applicationhotel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class RoomId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "id_hotel")
    private Hotel hotel;

    @Column(name = "room_number")
    private Integer roomNumber;
}
