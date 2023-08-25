package com.examen.PROG2.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Payment {
    private int idPayment;
    private boolean isPaid;
    private Double total;
}
