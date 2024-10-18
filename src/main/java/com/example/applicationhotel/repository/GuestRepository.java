package com.example.applicationhotel.repository;

import com.example.applicationhotel.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Integer> {
    Guest findByEmbg(String emgb);
}
