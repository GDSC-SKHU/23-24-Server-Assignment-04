package com.gdsc.ordersystem.controller.response.product;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductResponseDto {

    private Long productId;
    private String name;
    private Long unitprice;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public static ProductResponseDto of(Long id, String name, Long unitprice, LocalDateTime createAt, LocalDateTime updateAt) {
        return new ProductResponseDto(id, name, unitprice, createAt, updateAt);
    }

}
