package com.example.buy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long id;
    private Long customerId;
    private List<ItemDto> items;

    public List<Long> getItemIds() { // 추가한 부분
        return this.items.stream()
                .map(ItemDto::getId)
                .collect(Collectors.toList());
    }
}
