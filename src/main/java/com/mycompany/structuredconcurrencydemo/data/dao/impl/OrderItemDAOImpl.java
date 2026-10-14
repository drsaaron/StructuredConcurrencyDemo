/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.structuredconcurrencydemo.data.dao.impl;

import com.mycompany.structuredconcurrencydemo.data.OrderItem;
import com.mycompany.structuredconcurrencydemo.data.dao.OrderItemDAO;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 *
 * @author aar1069
 */
@Component
@Slf4j
public class OrderItemDAOImpl implements OrderItemDAO {

    private static int NEXT_ID = 1;
    
    private Map<Integer, OrderItem> data = new HashMap<>();

    @Override
    public Optional<OrderItem> getOrderItemById(int id) {
        
        log.info("getting order item {}", id);
        
        OrderItem i = data.get(id);
        return i != null ? Optional.of(i) : Optional.empty();
    }

    @Override
    public Collection<OrderItem> getOrderItemsByOrderId(int orderId) {
        log.info("getting oder items for order {}", orderId);
        
        return data.values().stream()
                .filter(i -> i.getOrderId() == orderId)
                .collect(Collectors.toList());
    }

    @Override
    public OrderItem saveOrderItem(OrderItem orderItem) {
        log.info("saving order item {}", orderItem);
        
        int id = NEXT_ID++;
        orderItem.setId(id);
        
        data.put(id, orderItem);
        
        return orderItem;
    }

    @Override
    public void clear() {
        NEXT_ID = 1;
        data = new HashMap<>();
    }

    @Override
    public Collection<OrderItem> getOrderItems() {
        return data.values();
    }
    
}
