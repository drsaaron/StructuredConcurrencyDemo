/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.structuredconcurrencydemo.data;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 *
 * @author aar1069
 */
@ExtendWith(SpringExtension.class)
@Slf4j
public class OrderViewTest {
    
    @TestConfiguration
    public static class OrderViewTestConfiguration {
        
    }
    
    public OrderViewTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getTotalCost method, of class OrderView.
     */
    @Test
    public void testGetTotalCost() {
        log.info("getTotalCost");
        
        List<OrderItem> items = List.of(
                new OrderItem(0, "j", BigDecimal.ONE, 10),
                new OrderItem(1, "d", new BigDecimal("100"), 50)
        );
        
        OrderView instance = new OrderView();
        instance.setOrderItems(items);

        BigDecimal expResult = new BigDecimal("5010");
        BigDecimal result = instance.getTotalCost();
        assertEquals(expResult, result);
    }


}
