package com.example.applicationhotel.web;

import com.example.applicationhotel.model.City;
import com.example.applicationhotel.model.Employee;
import com.example.applicationhotel.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class GuestController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final GuestRepository guestRepository;

    public GuestController(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @GetMapping("/guests")
    public String viewGuests(Model model) {
        String sql = "SELECT * FROM guestreservations";
        List<Map<String, Object>> guestreservations = jdbcTemplate.queryForList(sql);
        model.addAttribute("guestReservations", guestreservations);

        return "guestReservations";
    }

    @GetMapping("/guests/futureRes")
    public String futureRes(Model model){
        String sql = "SELECT * FROM futurereservations";
        List<Map<String, Object>> futureReservations = jdbcTemplate.queryForList(sql);
        model.addAttribute("futureReservations", futureReservations);

        return "futureRes.html";
    }

}
