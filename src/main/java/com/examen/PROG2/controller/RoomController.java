package com.examen.PROG2.controller;

import com.examen.PROG2.model.Room;
import com.examen.PROG2.service.RoomInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Room")
public class RoomController {
    private final RoomInterface roomInterface;

    public RoomController(RoomInterface roomInterface) {
        this.roomInterface = roomInterface;
    }

    @GetMapping("/getAllRoom")
    public List<Room> getAllRoom(){
        return roomInterface.getAllRoom();
    }

    @PostMapping("/insertRoom")
    public void insertRoom(@RequestBody Room room){
        roomInterface.insertClient(room);
    }

    @GetMapping("/findById/{id}")
    public Room findById(@PathVariable int id){
        return roomInterface.findById(id);
    }
    @PutMapping("/updateRoom/{id}")
    public void updateRoom(@RequestBody Room room, @PathVariable int id){
        roomInterface.updateRoom(room, id);
    }

    @DeleteMapping("/deleteRoom/{id}")
    public void deleteRoom(@PathVariable int id){
        roomInterface.deleteRoom(id);
    }
}
