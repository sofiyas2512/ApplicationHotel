package com.example.applicationhotel.service;

import com.example.applicationhotel.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAllById(Integer id);
    Employee create(Integer id, String embg, String name, String surname, String email, char gender,  Integer salary);
}
