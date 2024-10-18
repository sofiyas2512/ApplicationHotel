package com.example.applicationhotel.service.impl;

import com.example.applicationhotel.model.Employee;
import com.example.applicationhotel.repository.EmployeeRepository;
import com.example.applicationhotel.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAllById(Integer id) {
        return this.employeeRepository.findAllById(id);
    }

    @Override
    public Employee create(Integer id, String embg, String name, String surname, String email, char gender, Integer salary) {
        Employee employee = new Employee(id, embg, name, surname, email, gender,  salary);
        return employeeRepository.save(employee);
    }


}
