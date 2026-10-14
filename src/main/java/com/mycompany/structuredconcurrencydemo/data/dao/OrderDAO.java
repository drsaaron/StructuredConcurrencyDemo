/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.structuredconcurrencydemo.data.dao;

import com.mycompany.structuredconcurrencydemo.data.OrderData;
import java.util.Collection;
import java.util.Optional;

/**
 *
 * @author aar1069
 */
public interface OrderDAO {
    
    public Optional<OrderData> getOrderById(int id);
    
    public OrderData saveOrder(OrderData order);
    
    public Collection<OrderData> getOrders();
    
    void clear();
}
