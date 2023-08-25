package com.examen.PROG2.repository;

import com.examen.PROG2.model.Room;

import java.util.List;

public interface RoomDAO {

    List<Room> getAllRoom();

    void insertRoom(Room room);

    Room findById(int id);
}
