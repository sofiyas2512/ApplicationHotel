package com.example.applicationhotel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Reservations {

    @Id
    @Column(name = "id_reservations")
    private Integer id_reservations;

    private Integer num_of_people;

    @Temporal(TemporalType.DATE)
    private Date check_in;

    @Temporal(TemporalType.DATE)
    private Date check_out;


    @ManyToOne
    @JoinColumn(name = "id_guest")
    private Guest id_guest;



    @ManyToOne
    @JoinColumn(name = "id_bill")
    private Bill id_bill;


    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "id_hotel", referencedColumnName = "id_hotel"),
            @JoinColumn(name = "room_number", referencedColumnName = "room_number")
    })
    private Room room;

    public Reservations(Integer reservationsid, Integer num_of_people, java.sql.Timestamp check_in, java.sql.Timestamp check_out, Guest guest_id, Bill bill_id, Room room) {
        this.id_reservations = reservationsid;
        this.num_of_people = num_of_people;
        this.check_in = check_in;
        this.check_out = check_out;
        this.id_guest = guest_id;
        this.id_bill = bill_id;
        this.room = room;
    }

    public Reservations() {

    }
}
