package com.example.applicationhotel.web;

import com.example.applicationhotel.model.Guest;
import com.example.applicationhotel.model.Reservations;
import com.example.applicationhotel.repository.GuestRepository;
import com.example.applicationhotel.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    private final GuestRepository guestRepository;

    public ReservationController(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @GetMapping("/add")
    public String showAddReservationForm(Model model) {

        return "addReservation";
    }

    @PostMapping("/add")
    public String addReservation(
            @RequestParam Integer id_reservations,
            @RequestParam Integer num_of_people,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date check_in,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date check_out,
            @RequestParam Integer id_guest,
            @RequestParam Integer id_bill,
            @RequestParam Integer room_number) {
//        Guest guest = guestRepository.findByEmbg(embg);
        this.reservationService.createReservation(id_reservations, num_of_people, check_in, check_out,
                id_guest, id_bill,room_number);

        return "redirect:/hotels";
    }

    @GetMapping
    public String viewReservations(Model model) {
        return "reservations";
    }
}
