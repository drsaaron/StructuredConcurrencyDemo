/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.structuredconcurrencydemo.data;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author aar1069
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    
    private int id;
    private int orderId;
    private BigDecimal paidAmount;
    private LocalDate paymentDate;

    public Payment(int orderId, BigDecimal paidAmount, LocalDate paymentDate) {
        this.orderId = orderId;
        this.paidAmount = paidAmount;
        this.paymentDate = paymentDate;
    }
    
    
}
