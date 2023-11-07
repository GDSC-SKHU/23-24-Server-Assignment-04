package com.example.orderitem.item.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateItemRequest(
        @NotBlank
        String name,
        @NotNull
        Integer price,
        @NotNull
        Integer stockQuantity
) {
}
