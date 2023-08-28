package com.examen.PROG2.repository;

import com.examen.PROG2.JDBC.ConnectionDB;
import com.examen.PROG2.model.Reservation;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReservationRepository implements ReservationDAO{
    public final ConnectionDB connectionDB;

    public ReservationRepository(ConnectionDB connectionDB) {
        this.connectionDB = connectionDB;
    }

    @Override
    public List<Reservation> getAllReservation(){
        String sql = "SELECT * FROM Reservation";
        List<Reservation> allReservation = new ArrayList<>();
        try(PreparedStatement preparedStatement = connectionDB.getConnection().prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                allReservation.add(new Reservation(
                        resultSet.getInt( "idReservation"),
                        resultSet.getInt("numberReservation"),
                        resultSet.getTimestamp("dateReservation"),
                        resultSet.getInt("idClient_client"),
                        resultSet.getInt("idRoom_room")
                ));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return allReservation;
    }

    @Override
    public void insertReservation(Reservation reservation){
        String sql = "INSERT INTO Reservation (numberReservation, dateReservation, idClient_client, idRoom_room) VALUES (?, ?, ?, ?)";
        try(
                PreparedStatement statement = connectionDB.getConnection().prepareStatement(sql);
        ){
            statement.setInt(1, reservation.getNumberReservation());
            statement.setTimestamp(2, reservation.getDate());
            statement.setInt(3, reservation.getIdClient_client());
            statement.setInt(4, reservation.getIdRoom_room());
            statement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Reservation findById(int id) {
        String sql = "SELECT * FROM Reservation WHERE idReservation = ?";
        Reservation reservation = null;

        try (
                PreparedStatement preparedStatement = connectionDB.getConnection().prepareStatement(sql);
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                reservation = new Reservation(
                        resultSet.getInt("idReservation"),
                        resultSet.getInt("numberReservation"),
                        resultSet.getTimestamp("dateReservation"),
                        resultSet.getInt("idClient_client"),
                        resultSet.getInt("idRoom_room")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservation;
    }

    @Override
    public void updateReservation(Reservation reservation, int id){
        String sql = "UPDATE Reservation SET numberReservation = ?, dateReservation = ?, idClient_client = ?, idRoom_room = ? WHERE idReservation = ?";
        try(
                PreparedStatement statement = connectionDB.getConnection().prepareStatement(sql);
        ){
            statement.setInt(1, reservation.getNumberReservation());
            statement.setTimestamp(2, reservation.getDate());
            statement.setInt(3, reservation.getIdClient_client());
            statement.setInt(4, reservation.getIdRoom_room());
            statement.setInt(5, id);
            statement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteReservation(int id){
        String sql = "DELETE FROM Reservation WHERE idReservation = ?";
        try(
                PreparedStatement statement = connectionDB.getConnection().prepareStatement(sql)
        ) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
