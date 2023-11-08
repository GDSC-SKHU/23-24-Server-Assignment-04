package com.gdsc.ordersystem.controller.dto.request.order;

import com.gdsc.ordersystem.controller.dto.OrderDetailDto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreateRequestDto {

    @NotNull
    private Long userId;

    @NotEmpty
    private List<OrderDetailDto> orderDetailDtos;

}
