/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.structuredconcurrencydemo.data.dao.impl;

import static com.mycompany.structuredconcurrencydemo.InitializeDataCommandLineRunner.orders;
import com.mycompany.structuredconcurrencydemo.data.OrderData;
import java.time.LocalDate;
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
public class OrderDAOImplTest {
    
    @TestConfiguration
    public static class OrderDAOImplTestConfiguration {
        
        @Bean
        public OrderDAOImpl instance() {
            return new OrderDAOImpl();
        }
    }
    
    @Autowired
    private OrderDAOImpl instance;
    
    public OrderDAOImplTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    public static List<OrderData> orders = List.of(
            new OrderData(LocalDate.parse("2026-10-07"), "buyer 1"),
            new OrderData(LocalDate.parse("2026-10-15"), "buyer 2")
            );
    
    @BeforeEach
    public void setUp() {
        orders.stream().forEach(order -> instance.saveOrder(order));
    }
    
    @AfterEach
    public void tearDown() {
        instance.clear();
    }

    /**
     * Test of getOrderById method, of class OrderDAOImpl.
     */
    @Test
    public void testGetOrderById() {
        log.info("getOrderById");
        
        int id = 2;

        Optional<OrderData> result = instance.getOrderById(id);
        assertTrue(result.isPresent());
        
        result = instance.getOrderById(20000);
        assertTrue(result.isEmpty());
    }

    /**
     * Test of saveOrder method, of class OrderDAOImpl.
     */
    @Test
    public void testSaveOrder() {
        log.info("saveOrder");
        
        instance.clear();
        Collection<OrderData> orders = instance.getOrders();
        assertTrue(orders.isEmpty());
        
        OrderData order = new OrderData(LocalDate.EPOCH, "dude");
        OrderData result = instance.saveOrder(order);
        
        assertEquals(1, result.getId());
        
        orders = instance.getOrders();
        assertEquals(1, orders.size());
    }

    /**
     * Test of getOrders method, of class OrderDAOImpl.
     */
    @Test
    public void testGetOrders() {
        log.info("getOrders");
        
        Collection<OrderData> result = instance.getOrders();
        assertNotNull(result);
        assertEquals(2, result.size());
    }
    
}
