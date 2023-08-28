package com.examen.PROG2.service;

import com.examen.PROG2.model.Reservation;
import com.examen.PROG2.repository.ReservationDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService implements ReservationInterface{
    public final ReservationDAO reservationDAO;

    public ReservationService(ReservationDAO reservationDAO) {
        this.reservationDAO = reservationDAO;
    }

    @Override
    public List<Reservation> getAllReservation(){
        return reservationDAO.getAllReservation();
    }

    @Override
    public void insertReservation(Reservation reservation){
        reservationDAO.insertReservation(reservation);
    }

    @Override
    public Reservation findById(int id){
        return reservationDAO.findById(id);
    }

    @Override
    public void updateReservation(Reservation reservation, int id){
        reservationDAO.updateReservation(reservation, id);
    }

    @Override
    public void deleteReservation(int id){
        reservationDAO.deleteReservation(id);
    }
}
