package com.examen.PROG2.service;

import com.examen.PROG2.model.Room;
import com.examen.PROG2.repository.RoomDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService implements RoomInterface {
    private final RoomDAO roomDAO;

    public RoomService(RoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }

    @Override
    public List<Room> getAllRoom(){
        return roomDAO.getAllRoom();
    }
    @Override
    public void insertClient(Room room){
        roomDAO.insertRoom(room);
    }

    @Override
    public Room findById(int id){
        return roomDAO.findById(id);
    }
}
