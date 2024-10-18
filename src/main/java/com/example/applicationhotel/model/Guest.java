package com.example.applicationhotel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "guest")
public class Guest {
    @Id
    private Integer id;

    private String embg;
    private String name;
    private String surname;
    private String email;
    @Column(columnDefinition = "CHAR(1)")
    private char gender;

    @Column(name = "passport_number", nullable = false, columnDefinition = "varchar(255) default 'Person'")
    private String passport_number;

    public Guest(Integer id, String embg, String name, String surname, String email, char gender, String passport_number) {
        this.id = id;
        this.embg = embg;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.gender = gender;
        this.passport_number = passport_number;
    }

    public Guest() {}
}