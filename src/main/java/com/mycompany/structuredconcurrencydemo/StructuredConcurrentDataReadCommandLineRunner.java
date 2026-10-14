/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.structuredconcurrencydemo;

import com.mycompany.structuredconcurrencydemo.data.OrderData;
import com.mycompany.structuredconcurrencydemo.data.OrderItem;
import com.mycompany.structuredconcurrencydemo.data.OrderView;
import com.mycompany.structuredconcurrencydemo.data.dao.OrderDAO;
import com.mycompany.structuredconcurrencydemo.data.dao.OrderItemDAO;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.StructuredTaskScope.Subtask;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *
 * @author aar1069
 */
@Component
@Slf4j
@Order(2)
public class StructuredConcurrentDataReadCommandLineRunner implements CommandLineRunner {

    @Autowired
    private OrderDAO orderDAO;
    
    @Autowired
    private OrderItemDAO orderItemDAO;
    
    private OrderData fetchOrder(int id) {
        log.info("fetching order {}", id);
        
        return orderDAO.getOrderById(id).get();
    }
    
    private Collection<OrderItem> fetchOrderItems(int orderId) {
        log.info("fetching order items for {}", orderId);
        return orderItemDAO.getOrderItemsByOrderId(orderId);
    }
    
    private OrderView fetchOrderData(int id) {
        
        log.info("getting order view data for order {}", id);
        
        try (var scope = StructuredTaskScope.open(StructuredTaskScope.Joiner.allSuccessfulOrThrow())) {
            Subtask<OrderData> orderTask = scope.fork(() -> fetchOrder(id));
            Subtask<Collection<OrderItem>> orderItems = scope.fork(() -> fetchOrderItems(id));
            
            scope.join();
            
            OrderView view = new OrderView();
            view.setOrder(orderTask.get());
            view.setOrderItems(orderItems.get());
            
            return view;
        } catch (Exception e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Operation was interrupted", e);
        }
    }
    
    @Override
    public void run(String... args) throws Exception {
        log.info("reading the data in a structured concurrent way");
        
        Collection<Integer> orderIds = InitializeDataCommandLineRunner.orders.stream()
                .map(OrderData::getId)
                .collect(Collectors.toList());
        
        List<OrderView> allOrders = orderIds.parallelStream()
                .map(id -> fetchOrderData(id))
                .collect(Collectors.toList());
        
        log.info("allOrders = {}", allOrders);
    }
    
}
