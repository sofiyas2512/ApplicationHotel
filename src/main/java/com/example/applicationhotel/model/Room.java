package com.example.applicationhotel.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Room {
    @EmbeddedId
    private RoomId roomId;

    @Column(name = "room_type", nullable = false)
    private String room_type;

    @Column(name = "price")
    private Integer price;

    public Room(RoomId roomId, String room_type, Integer price) {
        this.roomId = roomId;
        this.room_type = room_type;
        this.price = price;
    }

    public Room() {

    }

}