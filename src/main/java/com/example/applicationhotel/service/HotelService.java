package com.example.applicationhotel.service;

import com.example.applicationhotel.model.City;
import com.example.applicationhotel.model.Hotel;

import java.util.List;

public interface HotelService {
    List<Hotel> getAllHotels();

    Hotel getHotelById(Integer hotelId);

    Hotel createHotel( String hotel_name, String address, City city);

    Hotel updateHotel(Integer id_hotel, String hotel_name, String address, City city);

    void deleteHotel(Integer hotelId);
}
