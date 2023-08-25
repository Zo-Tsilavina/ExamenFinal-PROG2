package com.examen.PROG2.repository;

import com.examen.PROG2.JDBC.ConnectionDB;
import com.examen.PROG2.model.Room;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RoomRepository implements RoomDAO{

    private final ConnectionDB connectionDB;

    public RoomRepository(ConnectionDB connectionDB) {
        this.connectionDB = connectionDB;
    }

    @Override
    public List<Room> getAllRoom() {
        String sql = "SELECT * FROM Room";
        List<Room> allRoom = new ArrayList<>();

        try(
                PreparedStatement preparedStatement = connectionDB.getConnection().prepareStatement(sql)
        ){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                allRoom.add(new Room(
                        resultSet.getInt("idRoom"),
                        resultSet.getString("name"),
                        resultSet.getBoolean("isEngaged"),
                        resultSet.getString("description")
                ));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return allRoom;
    }

    @Override
    public void insertRoom(Room room){
        String sql = "INSERT INTO Room (name, isEngaged, description) VALUES (?, ?, ?)";
        try(
                PreparedStatement statement = connectionDB.getConnection().prepareStatement(sql);
        ){
            statement.setString(1, room.getName());
            statement.setBoolean(2, room.isEngaged());
            statement.setString(3, room.getDescription());
            statement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Room findById(int id) {
        String sql = "SELECT * FROM Room WHERE idRoom = ?";
        Room room = null;

        try (
                PreparedStatement preparedStatement = connectionDB.getConnection().prepareStatement(sql);
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                room = new Room(
                        resultSet.getInt("idRoom"),
                        resultSet.getString("name"),
                        resultSet.getBoolean("isEngaged"),
                        resultSet.getString("description")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return room;
    }
}
