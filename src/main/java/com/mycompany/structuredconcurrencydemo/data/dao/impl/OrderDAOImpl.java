/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.structuredconcurrencydemo.data.dao.impl;

import com.mycompany.structuredconcurrencydemo.data.OrderData;
import com.mycompany.structuredconcurrencydemo.data.dao.OrderDAO;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 *
 * @author aar1069
 */
@Component
@Slf4j
public class OrderDAOImpl implements OrderDAO {

    private static int NEXT_ID = 1;
    
    private Map<Integer, OrderData> data = new HashMap<>();
    
    @Override
    public Optional<OrderData> getOrderById(int id) {
        log.info("getting order {}", id);
        
        OrderData o = data.get(id);
        return o != null ? Optional.of(o) : Optional.empty();
    }

    @Override
    public OrderData saveOrder(OrderData order) {
        log.info("saving order {}", order);
        
        int id = NEXT_ID++;
        order.setId(id);
        data.put(id, order);
        
        return order;
    }

    @Override
    public Collection<OrderData> getOrders() {
        return data.values();
    }

    @Override
    public void clear() {
        log.info("clearing data");
        
        NEXT_ID = 1;
        data = new HashMap<>();
    }
    
}
