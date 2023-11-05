package com.gdsc.ordersystem.controller.request.product;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductUnitPriceUpdateRequestDto {

    @NotNull
    private Long unitPrice;

}
