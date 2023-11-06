package com.gdsc.ordersystem.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderDetailDto {
    @NotNull
    private Long productId;
    @NotBlank
    private String productName;
    @NotNull
    private Long quantity;

    @Builder
    public OrderDetailDto(@NotNull Long productId, String productName, @NotNull Long quantity) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
    }
}
