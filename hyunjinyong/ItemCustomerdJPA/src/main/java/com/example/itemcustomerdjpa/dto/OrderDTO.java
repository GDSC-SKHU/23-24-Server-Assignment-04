package com.example.itemcustomerdjpa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Integer id;
    private String customerName;
    private String itemName;
}
