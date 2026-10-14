/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.structuredconcurrencydemo.data;

import java.math.BigDecimal;
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
public class OrderItem {
    
    private int id;
    private int orderId;
    private String name;
    private BigDecimal unitPrice;
    private int quanity;

    public OrderItem(int orderId, String name, BigDecimal unitPrice, int quanity) {
        this.orderId = orderId;
        this.name = name;
        this.unitPrice = unitPrice;
        this.quanity = quanity;
    }
    
    
}
