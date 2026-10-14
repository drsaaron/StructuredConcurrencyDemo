/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.structuredconcurrencydemo.data;

import java.math.BigDecimal;
import java.util.Collection;
import lombok.Data;

/**
 *
 * @author aar1069
 */
@Data
public class OrderView {
    
    private OrderData order;
    private Collection<OrderItem> orderItems;
    
    public BigDecimal getTotalCost() {
        return orderItems.stream()
                .map(i -> i.getUnitPrice().multiply(BigDecimal.valueOf(i.getQuanity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
