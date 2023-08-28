package com.examen.PROG2.controller;

import com.examen.PROG2.model.Payment;
import com.examen.PROG2.service.PaymentInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Payment")
public class PaymentController {
    private final PaymentInterface paymentInterface;

    public PaymentController(PaymentInterface paymentInterface) {
        this.paymentInterface = paymentInterface;
    }

    @GetMapping("/getAllPayment")
    public List<Payment> getAllPayment(){
        return paymentInterface.getAllPayment();
    }

    @PostMapping("/insertPayment")
    public void insertPayment(@RequestBody Payment payment){
        paymentInterface.insertPayment(payment);
    }

    @GetMapping("/findById/{id}")
    public Payment findById(@PathVariable int id){
        return paymentInterface.findById(id);
    }

    @PutMapping("/updatePayment/{id}")
    public void updatePayment(@RequestBody Payment payment, @PathVariable int id){
        paymentInterface.updatePayment(payment, id);
    }

    @DeleteMapping("/deletePayment/{id}")
    public void deletePayment(@PathVariable int id){
        paymentInterface.deletePayment(id);
    }
}
