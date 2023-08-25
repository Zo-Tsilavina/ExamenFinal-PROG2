package com.examen.PROG2.service;

import com.examen.PROG2.model.Room;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoomInterface {
    List<Room> getAllRoom();
    void insertClient(Room room);
    Room findById(int id);
}
