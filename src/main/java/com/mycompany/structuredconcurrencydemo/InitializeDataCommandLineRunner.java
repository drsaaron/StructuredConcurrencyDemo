/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.structuredconcurrencydemo;

import com.mycompany.structuredconcurrencydemo.data.OrderData;
import com.mycompany.structuredconcurrencydemo.data.OrderItem;
import com.mycompany.structuredconcurrencydemo.data.dao.OrderDAO;
import com.mycompany.structuredconcurrencydemo.data.dao.OrderItemDAO;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
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
@Order(1)
public class InitializeDataCommandLineRunner implements CommandLineRunner {

    @Autowired
    private OrderDAO orderDAO;
    
    @Autowired
    private OrderItemDAO orderItemDAO;
    
    public static List<OrderData> orders = List.of(
            new OrderData(LocalDate.parse("2026-10-07"), "buyer 1"),
            new OrderData(LocalDate.parse("2026-10-15"), "buyer 2")
            );
    
    public static List<OrderItem> orderItems = List.of(
            new OrderItem(1, "watch1", BigDecimal.ONE, 100),
            new OrderItem(1, "watch2", new BigDecimal("100"), 10),
            new OrderItem(2, "TV", new BigDecimal("1000"), 2)
            );
    
    @Override
    public void run(String... args) throws Exception {
        log.info("initializing data");
        
        orders.stream().forEach(order -> orderDAO.saveOrder(order));
        orderItems.stream().forEach(i -> orderItemDAO.saveOrderItem(i));
        
        log.info("orders after save: {}", orders);
        log.info("order items after save: {}", orderItems);
    }
    
}
