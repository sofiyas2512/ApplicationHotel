package com.example.applicationhotel.web;


import com.example.applicationhotel.model.City;
import com.example.applicationhotel.model.Hotel;
import com.example.applicationhotel.repository.CityRepository;
import com.example.applicationhotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class HotelController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private CityRepository cityRepository;
    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/hotels")
    public String viewHotels(Model model) {
        String sql = "SELECT * FROM hotel_summary";
        List<Map<String, Object>> hotelSummaryList = jdbcTemplate.queryForList(sql);
        model.addAttribute("hotelSummaryList", hotelSummaryList);

        return "hotels";
    }

    @GetMapping("/cities")
    public String viewCities(Model model) {
        String citiesSql = "SELECT * FROM cities";
        List<Map<String, Object>> citiesList = jdbcTemplate.queryForList(citiesSql);
        model.addAttribute("citiesList", citiesList);

        return "cities";
    }
    @GetMapping("/cities/add")
    public String showAddCity() {
        return "addCity";
    }
    @PostMapping("/cities/add")
    public String addCity(
            @RequestParam Integer id_city,
            @RequestParam String name) {


        City city = new City();
        city.setIdCity(id_city);
        city.setName_city(name);


        cityRepository.save(city);

        return "redirect:/cities";
    }

    @GetMapping("/hotelsinfo/{hotelId}")
    public String viewHotelInfo(@PathVariable Integer hotelId, Model model) {

        String detailedSql = "SELECT * FROM hotels WHERE hotel_id = ?";
        List<Map<String, Object>> hotelDetailsList = jdbcTemplate.queryForList(detailedSql, hotelId);
        model.addAttribute("hotelDetailsList", hotelDetailsList);

        return "hotelsinfo";
    }
    @GetMapping("/hotels/add")
    public String showAddHotel(Model model) {
        model.addAttribute("cities", cityRepository.findAll());
        return "addHotel";
    }

    @PostMapping("/hotels")
    public String createHotel(
            @RequestParam String hotelName,
            @RequestParam String address,
            @RequestParam Integer cityId) {
        City city = new City();
        city.setIdCity(cityId);
        hotelService.createHotel( hotelName, address, city);
        return "redirect:/hotels";
    }
}