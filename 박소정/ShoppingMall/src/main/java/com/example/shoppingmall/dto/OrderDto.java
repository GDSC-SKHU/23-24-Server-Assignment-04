package com.example.shoppingmall.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Integer id;
    private CustomerDto customer;
    private ItemDto item;
    private Integer count;
}