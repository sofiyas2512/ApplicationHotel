package com.example.applicationhotel.repository;

import com.example.applicationhotel.model.Room;
import com.example.applicationhotel.model.RoomId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, RoomId> {
    Room findRoomByRoomIdRoomNumber(Integer room_number);
}