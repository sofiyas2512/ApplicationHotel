package com.example.applicationhotel.web;

import com.example.applicationhotel.service.HotelService;
import com.example.applicationhotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Controller
public class RoomController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private HotelService hotelService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/rooms")
    public String getRoomsByHotel(@RequestParam Integer id_hotel, Model model) {
        String detailedSql = "SELECT * FROM rooms WHERE id_hotel = ?";
        List<Map<String, Object>> rooms = jdbcTemplate.queryForList(detailedSql, id_hotel);
        model.addAttribute("probno", rooms);
        return "rooms";
    }
}



