package com.gdsc.ordersystem.controller.dto.response.product;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductDeleteResponseDto {

    Long productId;

    public static ProductDeleteResponseDto of(Long productId){
        return new ProductDeleteResponseDto(productId);
    }

}
