package com.examen.PROG2.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Client {
    private int idClient;
    private String firstName;
    private String lastName;
    private String number;
}
