package com.examen.PROG2.repository;

import com.examen.PROG2.model.Reservation;

import java.util.List;

public interface ReservationDAO{
    List<Reservation> getAllReservation();

    void insertReservation(Reservation reservation);

    Reservation findById(int id);

    void updateReservation(Reservation reservation, int id);

    void deleteReservation(int id);
}
