package com.examen.PROG2.repository;

import com.examen.PROG2.model.Payment;

import java.util.List;

public interface PaymentDAO {
    List<Payment> getAllPayment();

    void insertPayment(Payment payment);

    Payment findById(int id);

    void updatePayment(Payment payment, int id);

    void deletePayment(int id);
}
