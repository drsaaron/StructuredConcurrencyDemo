/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.structuredconcurrencydemo.data.dao;

import com.mycompany.structuredconcurrencydemo.data.OrderItem;
import java.util.Collection;
import java.util.Optional;

/**
 *
 * @author aar1069
 */
public interface OrderItemDAO {
    
    public Optional<OrderItem> getOrderItemById(int id);
    public Collection<OrderItem> getOrderItemsByOrderId(int orderId);
    
    public OrderItem saveOrderItem(OrderItem orderItem);
    
    public void clear();
    
    public Collection<OrderItem> getOrderItems();
}
