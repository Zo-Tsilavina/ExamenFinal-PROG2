package com.examen.PROG2.repository;

import com.examen.PROG2.JDBC.ConnectionDB;
import com.examen.PROG2.model.Client;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ClientRepository implements ClientDAO {
    private final ConnectionDB connectionDB;

    public ClientRepository(ConnectionDB connectionDB) {
        this.connectionDB = connectionDB;
    }

    @Override
    public List<Client> getAllClient() {
        String sql = "SELECT * FROM Client";
        List<Client> allClients = new ArrayList<>();

        try(
                PreparedStatement preparedStatement = connectionDB.getConnection().prepareStatement(sql)
        ){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                allClients.add(new Client(
                        resultSet.getInt("idClient"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("number")
                ));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return allClients;
    }

    @Override
    public void insertClient(Client client){
        String sql = "INSERT INTO Client (firstName, lastName, number) VALUES (?, ?, ?)";
        try(
                PreparedStatement statement = connectionDB.getConnection().prepareStatement(sql);
        ){
            statement.setString(1, client.getFirstName());
            statement.setString(2, client.getLastName());
            statement.setString(3, client.getNumber());
            statement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Client findById(int id) {
        String sql = "SELECT * FROM Client WHERE idClient = ?";
        Client client = null;

        try (
                PreparedStatement preparedStatement = connectionDB.getConnection().prepareStatement(sql);
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                client = new Client(
                        resultSet.getInt("idClient"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("number")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public void updateClient(Client client, int id){
        String sql = "UPDATE Client SET firstName = ?, lastName = ?, number = ? WHERE idClient = ?";
        try(
                PreparedStatement statement = connectionDB.getConnection().prepareStatement(sql);
        ){
            statement.setString(1, client.getFirstName());
            statement.setString(2, client.getLastName());
            statement.setString(3, client.getNumber());
            statement.setInt(4, id);
            statement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteClient(int id){
        String sql = "DELETE FROM Client WHERE idClient = ?";
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
