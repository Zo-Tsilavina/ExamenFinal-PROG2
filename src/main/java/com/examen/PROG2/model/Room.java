package com.examen.PROG2.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Room {
    private int idRoom;
    private String name;
    private boolean isEngaged;
    private String description;

}
