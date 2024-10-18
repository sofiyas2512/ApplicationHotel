package com.example.applicationhotel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    private Integer id;

    private String embg;
    private String name;
    private String surname;
    private String email;

    @Column(columnDefinition = "CHAR(1)")
    private char gender;

    @ManyToOne
    @JoinColumn(name = "id_hotel")
    private Hotel hotel;

    private Integer salary;

    public Employee(Integer id, String embg, String name, String surname, String email, char gender,  Integer salary) {
        this.id = id;
        this.embg = embg;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.gender = gender;

        this.salary = salary;
    }

    public Employee() {}
}