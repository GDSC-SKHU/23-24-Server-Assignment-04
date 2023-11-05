package com.example.jpa_exercise.dto;

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
public class OrderDto {
    private Integer id;
    private String name;
    private Integer price;
    private List<ItemDto> items = new ArrayList<>();
}

