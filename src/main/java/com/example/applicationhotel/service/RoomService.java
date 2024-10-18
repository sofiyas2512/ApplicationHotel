package com.example.applicationhotel.service;

import com.example.applicationhotel.model.Room;
import com.example.applicationhotel.model.RoomId;

import java.util.List;

public interface RoomService {
    List<Room> getAllRooms();

    Room getRoomById(RoomId roomId);

    Room createRoom(RoomId roomId, String room_type, Integer price);

    void deleteRoom(RoomId roomId);
}
