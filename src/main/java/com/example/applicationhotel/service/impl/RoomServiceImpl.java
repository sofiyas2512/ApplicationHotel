package com.example.applicationhotel.service.impl;

import com.example.applicationhotel.model.Room;
import com.example.applicationhotel.model.RoomId;
import com.example.applicationhotel.repository.RoomRepository;
import com.example.applicationhotel.service.RoomService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Room getRoomById(RoomId roomId) {
        return roomRepository.findById(roomId)
                .orElseThrow(() -> new EntityNotFoundException("Room not found with id: " + roomId));
    }

    @Override
    public Room createRoom(RoomId roomId, String room_type, Integer price) {
        Room room = new Room(roomId, room_type, price);
        return this.roomRepository.save(room);
    }

    @Override
    public void deleteRoom(RoomId roomId) {
        roomRepository.deleteById(roomId);
    }
}
