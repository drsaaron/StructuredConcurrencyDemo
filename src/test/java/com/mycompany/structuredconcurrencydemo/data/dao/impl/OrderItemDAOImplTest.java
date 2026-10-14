/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.structuredconcurrencydemo.data.dao.impl;

import static com.mycompany.structuredconcurrencydemo.InitializeDataCommandLineRunner.orderItems;
import com.mycompany.structuredconcurrencydemo.data.OrderItem;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 *
 * @author aar1069
 */
@ExtendWith(SpringExtension.class)
@Slf4j
public class OrderItemDAOImplTest {
    
    @TestConfiguration
    public static class OrderItemDAOImplTestConfiguration {
        
        @Bean
        public OrderItemDAOImpl instance() {
            return new OrderItemDAOImpl();
        }
    }
    
    @Autowired
    private OrderItemDAOImpl instance;
    
    public OrderItemDAOImplTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    public static List<OrderItem> orderItems = List.of(
            new OrderItem(1, "watch1", BigDecimal.ONE, 100),
            new OrderItem(1, "watch2", new BigDecimal("100"), 10),
            new OrderItem(2, "TV", new BigDecimal("1000"), 2)
            );
    
    @BeforeEach
    public void setUp() {
        
        orderItems.stream().forEach(i -> instance.saveOrderItem(i));
    }
    
    @AfterEach
    public void tearDown() {
        instance.clear();
    }

    /**
     * Test of getOrderItemById method, of class OrderItemDAOImpl.
     */
    @Test
    public void testGetOrderItemById() {
        log.info("getOrderItemById");

        int id = 3;
        Optional<OrderItem> result = instance.getOrderItemById(id);
        assertTrue(result.isPresent());
        
        result = instance.getOrderItemById(3000);
        assertTrue(result.isEmpty());
    }

    /**
     * Test of getOrderItemsByOrderId method, of class OrderItemDAOImpl.
     */
    @Test
    public void testGetOrderItemsByOrderId() {
        log.info("getOrderItemsByOrderId");
        
        int orderId = 1;
        Collection<OrderItem> result = instance.getOrderItemsByOrderId(orderId);
        assertEquals(2, result.size());
    }

    /**
     * Test of saveOrderItem method, of class OrderItemDAOImpl.
     */
    @Test
    public void testSaveOrderItem() {
        log.info("saveOrderItem");
        
        instance.clear();
        
        Collection<OrderItem> items = instance.getOrderItems();
        assertNotNull(items);
        assertTrue(items.isEmpty());
        
        OrderItem orderItem = new OrderItem(0, "yo", BigDecimal.ONE, 0);
        OrderItem result = instance.saveOrderItem(orderItem);
        assertEquals(1, result.getId());
        
        items = instance.getOrderItems();
        assertTrue(items.size() == 1);
    }

    /**
     * Test of clear method, of class OrderItemDAOImpl.
     */
    @Test
    public void testClear() {
        log.info("clear");

        Collection<OrderItem> items = instance.getOrderItems();
        assertFalse(items.isEmpty());
        
        instance.clear();
        
        items = instance.getOrderItems();
        assertTrue(items.isEmpty());
        
    }

    /**
     * Test of getOrderItems method, of class OrderItemDAOImpl.
     */
    @Test
    public void testGetOrderItems() {
        log.info("getOrderItems");

        Collection<OrderItem> result = instance.getOrderItems();
        assertEquals(orderItems.size(), result.size());
        
    }
    
}
