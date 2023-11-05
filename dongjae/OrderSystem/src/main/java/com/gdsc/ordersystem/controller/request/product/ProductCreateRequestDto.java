package com.gdsc.ordersystem.controller.request.product;

import com.gdsc.ordersystem.domain.product.Product;
import com.gdsc.ordersystem.domain.user.User;
import com.gdsc.ordersystem.domain.user.UserType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreateRequestDto {

    @NotBlank
    private String name;
    @NotBlank
    private Long unitPrice;

    public Product toEntity() {
        return Product.builder()
                .name(name)
                .unitPrice(unitPrice)
                .build();
    }

}
