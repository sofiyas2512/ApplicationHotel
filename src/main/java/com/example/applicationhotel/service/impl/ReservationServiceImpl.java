package com.example.applicationhotel.service.impl;

import com.example.applicationhotel.model.*;
import com.example.applicationhotel.repository.*;
import com.example.applicationhotel.service.ReservationService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationsRepository reservationsRepository;
    private final BillRepository billRepository;
    private final GuestRepository guestRepository;

    private final RoomRepository roomRepository;
    public ReservationServiceImpl(ReservationsRepository reservationsRepository, BillRepository billRepository, GuestRepository guestRepository,  RoomRepository roomRepository) {
        this.reservationsRepository = reservationsRepository;
        this.billRepository = billRepository;
        this.guestRepository = guestRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Reservations> getAllReservations() {
        return this.reservationsRepository.findAll();
    }

    @Override
    public Reservations getReservationById(Long reservationId) {
        return reservationsRepository.findById(reservationId)
                .orElseThrow(() -> new EntityNotFoundException("Reservation not found with id: " + reservationId));
    }

    @Override
    public Reservations createReservation(Integer reservationsid, Integer num_of_people, Date check_in, Date check_out, Integer guest_id, Integer bill_id,  Integer room_number) {
        Bill bill_id2 = billRepository.findById(bill_id).get();
//        Person person = personRepository.findById(guest_id).get();
        Guest guest_id2 = guestRepository.findById(guest_id).get();
        String embg = guest_id2.getEmbg();
        Room room = roomRepository.findRoomByRoomIdRoomNumber(room_number);

        Reservations reservation = new Reservations(reservationsid, num_of_people,check_in, check_out, guest_id2, bill_id2, room);
        return this.reservationsRepository.save(reservation);
    }

    @Override
    public Reservations updateReservation(Long reservationsid, Integer num_of_people, Date check_in,Date check_out, Guest guest_id, Bill bill_id, Room room) {
        return null;
    }
    @Override
    public Reservations deleteReservation(Long reservationId) {
        Reservations reservation =  reservationsRepository.findById(reservationId)
                .orElseThrow(() -> new EntityNotFoundException("Reservation not found with id: " + reservationId));
        this.reservationsRepository.delete(reservation);
        return reservation;
    }

}
