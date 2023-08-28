package com.examen.PROG2.service;

import com.examen.PROG2.model.Payment;
import com.examen.PROG2.repository.PaymentDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService implements PaymentInterface{
    private final PaymentDAO paymentDAO;

    public PaymentService(PaymentDAO paymentDAO) {
        this.paymentDAO = paymentDAO;
    }

    @Override
    public List<Payment> getAllPayment(){
        return paymentDAO.getAllPayment();
    }

    @Override
    public void insertPayment(Payment payment){
        paymentDAO.insertPayment(payment);
    }

    @Override
    public Payment findById(int id){
        return paymentDAO.findById(id);
    }

    @Override
    public void updatePayment(Payment payment, int id){
        paymentDAO.updatePayment(payment, id);
    }

    @Override
    public void deletePayment(int id){
        paymentDAO.deletePayment(id);
    }
}
