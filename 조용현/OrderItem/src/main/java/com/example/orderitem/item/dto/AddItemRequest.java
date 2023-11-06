package com.example.orderitem.item.dto;

import com.example.orderitem.domain.Address;
import com.example.orderitem.domain.Item;
import com.example.orderitem.domain.Member;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AddItemRequest(
        @NotBlank
        String name,

        @NotNull
        Integer price,

        @NotNull
        Integer stockQuantity
) {
        public Item toEntity() {
                return Item.builder()
                        .name(this.name)
                        .price(this.price)
                        .stockQuantity(this.stockQuantity)
                        .build();
        }
}
