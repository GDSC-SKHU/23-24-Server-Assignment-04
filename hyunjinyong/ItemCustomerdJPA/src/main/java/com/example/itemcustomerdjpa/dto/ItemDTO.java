package com.example.itemcustomerdjpa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
    private Integer id;
    private String name;
    private int price;
}
