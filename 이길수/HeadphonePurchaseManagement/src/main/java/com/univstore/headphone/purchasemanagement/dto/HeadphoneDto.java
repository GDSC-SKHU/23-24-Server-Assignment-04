package com.univstore.headphone.purchasemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HeadphoneDto {
    private Integer id;
    private String brand;
    private String name;
    private Integer price;
    private List<OrderDto> orders = new ArrayList<>();
}
