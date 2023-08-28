package com.examen.PROG2.repository;

import com.examen.PROG2.JDBC.ConnectionDB;
import com.examen.PROG2.model.Payment;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentRepository implements PaymentDAO{
    private final ConnectionDB connectionDB;

    public PaymentRepository(ConnectionDB connectionDB) {
        this.connectionDB = connectionDB;
    }

    @Override
    public List<Payment> getAllPayment() {
        String sql = "SELECT * FROM Payment";
        List<Payment> allPayment = new ArrayList<>();

        try(
                PreparedStatement preparedStatement = connectionDB.getConnection().prepareStatement(sql)
        ){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                allPayment.add(new Payment(
                        resultSet.getInt("idPayment"),
                        resultSet.getBoolean("isPaid"),
                        resultSet.getDouble("total"),
                        resultSet.getInt("idClient_client")
                ));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return allPayment;
    }

    @Override
    public void insertPayment(Payment payment){
        String sql = "INSERT INTO Payment (isPaid, total, idClient_client) VALUES (?, ?, ?)";
        try(
                PreparedStatement statement = connectionDB.getConnection().prepareStatement(sql);
        ){
            statement.setBoolean(1, payment.isPaid());
            statement.setDouble(2, payment.getTotal());
            statement.setInt(3, payment.getIdClient_client());
            statement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Payment findById(int id) {
        String sql = "SELECT * FROM Payment WHERE idPayment = ?";
        Payment payment = null;

        try (
                PreparedStatement preparedStatement = connectionDB.getConnection().prepareStatement(sql);
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                payment = new Payment(
                        resultSet.getInt("idPayment"),
                        resultSet.getBoolean("isPaid"),
                        resultSet.getDouble("total"),
                        resultSet.getInt("idClient_client")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payment;
    }

    @Override
    public void updatePayment(Payment payment, int id){
        String sql = "UPDATE Payment SET isPaid = ?, total = ?, idClient_client = ? WHERE idPayment = ?";
        try(
                PreparedStatement statement = connectionDB.getConnection().prepareStatement(sql);
        ){
            statement.setBoolean(1, payment.isPaid());
            statement.setDouble(2, payment.getTotal());
            statement.setInt(3, payment.getIdClient_client());
            statement.setInt(4, id);
            statement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deletePayment(int id){
        String sql = "DELETE FROM Payment WHERE idPayment = ?";
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
