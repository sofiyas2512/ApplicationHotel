package com.example.applicationhotel.service.impl;

import com.example.applicationhotel.model.City;
import com.example.applicationhotel.model.Hotel;
import com.example.applicationhotel.repository.HotelRepository;
import com.example.applicationhotel.service.HotelService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;

    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }


    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelById(Integer hotelId) {
        return hotelRepository.findById(hotelId)
                .orElseThrow(() -> new EntityNotFoundException("Hotel not found with id: " + hotelId));
    }

    @Override
    public Hotel createHotel( String hotel_name, String address, City city) {
        Hotel hotel = new Hotel( hotel_name, address, city);
        Random random = new Random();
        hotel.setId_hotel(random.nextInt(1000));
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel updateHotel(Integer id_hotel, String hotel_name, String address, City city) {
        Hotel hotel =  hotelRepository.findById(id_hotel)
                .orElseThrow(() -> new EntityNotFoundException("Hotel not found with id: " + id_hotel));
        hotel.setId_hotel(id_hotel);
        hotel.setName(hotel_name);
        hotel.setAddress(address);
        hotel.setCity(city);

        return hotelRepository.save(hotel);
    }

    @Override
    public void deleteHotel(Integer hotelId) {
        hotelRepository.deleteById(hotelId);
    }
}
