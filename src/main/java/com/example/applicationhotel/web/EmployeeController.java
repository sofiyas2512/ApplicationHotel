package com.example.applicationhotel.web;

import com.example.applicationhotel.repository.HotelRepository;
import com.example.applicationhotel.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final HotelRepository hotelRepository;
    private final EmployeeService employeeService;

    public EmployeeController(HotelRepository hotelRepository, EmployeeService employeeService) {
        this.hotelRepository = hotelRepository;
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String viewEmployeesByHotel(@RequestParam Integer id_hotel, Model model) {
        String detailedSql = "SELECT * FROM employee  WHERE id_hotel = ?";
        List<Map<String, Object>> employees = jdbcTemplate.queryForList(detailedSql, id_hotel);
        model.addAttribute("probno", employees);

        return "employees";
    }

    @GetMapping("/employees/add")
    public String showAddEmployee(Model model) {
        model.addAttribute("hotels", hotelRepository.findAll());
        return "addEmployee";
    }

    @PostMapping("/employees")
    public String addEmployee(
            @RequestParam Integer id,
            @RequestParam String embg,
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String email,
            @RequestParam char gender,
            @RequestParam Integer salary) {

            employeeService.create(id, embg, name, surname, email, gender, salary);

        return "redirect:/hotels";
    }
}

