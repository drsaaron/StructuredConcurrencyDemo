/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.structuredconcurrencydemo.data.dao;

import com.mycompany.structuredconcurrencydemo.data.Payment;
import java.util.Optional;

/**
 *
 * @author aar1069
 */
public interface PaymentDAO {
    
    public Optional<Payment> getPaymentById(int id);
    public Optional<Payment> getPaymentByOrderId(int orderId);
    
    public Payment savePayment(Payment payment);
}
