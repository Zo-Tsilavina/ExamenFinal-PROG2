package com.examen.PROG2.controller;

import com.examen.PROG2.model.Reservation;
import com.examen.PROG2.service.ReservationInterface;
import org.apache.catalina.LifecycleState;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Reservation")
public class ReservationController {
    public final ReservationInterface reservationInterface;

    public ReservationController(ReservationInterface reservationInterface) {
        this.reservationInterface = reservationInterface;
    }

    @GetMapping("/getAllReservation")
    public List<Reservation> getAllReservation(){
        return reservationInterface.getAllReservation();
    }

    @PostMapping("/insertReservation")
    public void insertReservation(@RequestBody Reservation reservation){
        reservationInterface.insertReservation(reservation);
    }

    @GetMapping("/findById/{id}")
    public Reservation findById(@PathVariable int id){
        return reservationInterface.findById(id);
    }

    @PutMapping("/updateReservation/{id}")
    public void updateReservation(@RequestBody Reservation reservation, @PathVariable int id){
        reservationInterface.updateReservation(reservation, id);
    }

    @DeleteMapping("/deleteReservation/{id}")
    public void deleteReservation(@PathVariable int id){
        reservationInterface.deleteReservation(id);
    }
}
