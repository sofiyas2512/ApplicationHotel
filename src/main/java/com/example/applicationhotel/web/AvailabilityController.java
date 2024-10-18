package com.example.applicationhotel.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AvailabilityController {

    private final JdbcTemplate jdbcTemplate;

    public AvailabilityController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/availability")
    public String availability(
            @RequestParam(name = "hotelName", required = false) String hotelName,
            Model model
    ) {
        executeSqlQuery();
        String selectQuery = "SELECT * FROM hotelsIsAvailable WHERE 1=1";
                if (hotelName != null && !hotelName.isEmpty()) {
            selectQuery += " AND hotel_name LIKE '%" + hotelName + "%'";
        }
        List<Map<String, Object>> hotelDetailsList = jdbcTemplate.queryForList(selectQuery);
        model.addAttribute("hotelDetailsList", hotelDetailsList);


        return "availability";
    }



    private void executeSqlQuery() {
        String sqlQuery =
                "SELECT DISTINCT h.name AS hotel_name, r.room_type, r.room_number, r.price, h.address, c.name AS city_name " +
                "FROM hotel h " +
                "LEFT JOIN city c ON h.id_city = c.id_city " +
                "LEFT JOIN room r ON r.id_hotel = h.id_hotel " +
                "LEFT JOIN reservations res ON r.id_hotel = h.id_hotel " +
                "WHERE (r.room_number NOT IN ( " +
                "    SELECT room_number " +
                "    FROM reservations res " +
                "    WHERE (NOW() BETWEEN check_in AND check_out) " +
                ") OR (res.room_number IS NULL)) " +
                "AND (res.check_out IS NOT NULL OR res.check_out > NOW())";


        jdbcTemplate.execute(sqlQuery);
    }
}
