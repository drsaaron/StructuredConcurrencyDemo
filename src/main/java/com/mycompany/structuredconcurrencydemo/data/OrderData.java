/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.structuredconcurrencydemo.data;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author aar1069
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderData {
    
    private int id;
    private LocalDate effectiveDate;
    private String buyer;

    public OrderData(LocalDate effectiveDate, String buyer) {
        this.effectiveDate = effectiveDate;
        this.buyer = buyer;
    }
    
    
}
