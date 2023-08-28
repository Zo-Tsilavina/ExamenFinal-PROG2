DROP DATABASE IF EXISTS hotely;
CREATE DATABASE hotely;
\c hotely;

CREATE TABLE Client(
        idClient     Serial PRIMARY KEY,
        firstName     Varchar (100),
        lastName     Varchar (100),
        number     Varchar (20)
);



CREATE TABLE Payment(
        idPayment     Serial PRIMARY KEY,
        isPaid     Boolean,
        total     Double Precision,
        idClient_Client     Integer REFERENCES Client(idClient)
);



CREATE TABLE Room(
        idRoom     Serial PRIMARY KEY,
        name     Varchar (50),
        isEngaged     Boolean,
        description     Text
);



CREATE TABLE Reservation(
        idReservation     Serial PRIMARY KEY,
        numberReservation     Integer,
        dateReservation     Date,
        idClient_Client     Integer REFERENCES Client(idClient),
        idRoom_room     Integer REFERENCES Room(idRoom)
);

-- ============================== INSERT CLIENT ============================================= ---

INSERT INTO Client (firstName, lastName, number)
VALUES
    ('John', 'Doe', '1234567890'),
    ('Jane', 'Smith', '9876543210'),
    ('Michael', 'Johnson', '5551234567'),
    ('Emily', 'Williams', '8885554321'),
    ('David', 'Brown', '7778889999'),
    ('Sarah', 'Miller', '5557891234'),
    ('Robert', 'Davis', '4443332222'),
    ('Jennifer', 'Jones', '5556667777'),
    ('William', 'Garcia', '2224445555'),
    ('Amanda', 'Martinez', '3335556666');



-- ============================== INSERT PAYMENT =============================================== --
INSERT INTO Payment (isPaid, total, idClient_Client)
VALUES (TRUE, 100.0, 1),
        (FALSE, 75.0, 2),
        (TRUE, 150.0, 3),
        (FALSE, 50.0, 4),
        (FALSE, 75.0, 5),
        (TRUE, 62.0, 6),
        (TRUE, 50.0, 7),
        (TRUE, 25.0, 8),
        (FALSE, 225.0, 9),
        (TRUE, 12.0, 10);


-- ==============================  INSERT ROOM ================================================ --

INSERT INTO Room (name, isEngage, description)
VALUES
    ('simple', false, 'A comfortable single bed with basic amenities.'),
    ('simple', true, 'Cozy room with a single bed and a small workspace.'),
    ('simple', false, 'Simple and affordable room with all the essential features.'),
    ('simple', true, 'A compact room with a single bed for a peaceful stay.');

INSERT INTO Room (name, isEngage, description)
VALUES
    ('twice', false, 'Spacious room with twin beds, perfect for sharing.'),
    ('twice', true, 'Two single beds and additional space for a comfortable stay.'),
    ('twice', false, 'Room designed for two occupants with twin beds and modern amenities.'),
    ('twice', true, 'Dual beds and ample space for a relaxing stay together.');

INSERT INTO Room (name, isEngage, description)
VALUES
    ('VIP', false, 'Luxurious suite with a king-sized bed, a living area, and premium amenities.'),
    ('VIP', true, 'Elegant VIP room featuring a plush king bed and stunning city views.'),
    ('VIP', false, 'Exquisite suite with top-notch comforts, ideal for a lavish experience.'),
    ('VIP', true, 'Opulent VIP accommodation with exclusive services and high-class design.');

-- ======================================= INSERT RESERVATION ========================================= --

INSERT INTO Reservation (numberReservation, dateReservation, idClient_Client, idRoom_room)
VALUES
    (1, '2023-09-01', 1, 7),
    (2, '2023-09-02', 2, 4),
    (1, '2023-09-03', 3, 1),
    (2, '2023-09-04', 4, 8),
    (1, '2023-09-05', 5, 5),
    (2, '2023-09-06', 6, 2),
    (2, '2023-09-07', 7, 9),
    (2, '2023-09-08', 8, 6),
    (1, '2023-09-09', 9, 3),
    (1, '2023-09-10', 10, 10);
