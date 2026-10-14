/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.structuredconcurrencydemo.data;

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
}
