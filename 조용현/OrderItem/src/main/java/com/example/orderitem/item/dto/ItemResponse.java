package com.example.orderitem.item.dto;

import com.example.orderitem.domain.Item;

public record ItemResponse(

        Long itemId,
        String name,
        Integer price,
        Integer stockQuantity
) {
    public static ItemResponse createInstance(Item item) {
        return new ItemResponse(item.getId(), item.getName(), item.getPrice(), item.getStockQuantity());
    }
}
