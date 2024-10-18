package com.example.applicationhotel.service;

import com.example.applicationhotel.model.Bill;
import com.example.applicationhotel.model.Guest;
import com.example.applicationhotel.model.Reservations;
import com.example.applicationhotel.model.Room;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface ReservationService {
    List<Reservations> getAllReservations();

    Reservations getReservationById(Long reservationId);

    Reservations createReservation(Integer reservationsid, Integer num_of_people, Date check_in, Date check_out, Integer guest_id, Integer bill_id, Integer room_number);

    Reservations updateReservation(Long reservationsid, Integer num_of_people,  Date check_in, Date check_out, Guest guest_id, Bill bill_id, Room room);

    Reservations deleteReservation(Long reservationId);
}
