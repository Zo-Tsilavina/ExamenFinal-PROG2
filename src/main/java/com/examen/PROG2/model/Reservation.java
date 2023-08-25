package com.examen.PROG2.model;

import lombok.*;

import java.sql.Date;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Reservation {
    private int idReservation;
    private int numberReservation;
    private LocalDate date;
}
