package com.gdsc.ordersystem.controller;

import com.gdsc.ordersystem.common.dto.ApiResponse;
import com.gdsc.ordersystem.controller.dto.request.order.OrderCreateRequestDto;
import com.gdsc.ordersystem.controller.dto.response.order.OrderResponseDto;
import com.gdsc.ordersystem.exception.SuccessCode;
import com.gdsc.ordersystem.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<OrderResponseDto> createOrder(@RequestBody @Valid final OrderCreateRequestDto requestDto) {
        final OrderResponseDto data = orderService.createOrder(requestDto);
        return ApiResponse.success(SuccessCode.CREATE_ORDER_SUCCESS, data);
    }

    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<List<OrderResponseDto>> getOrdersByUserId(@PathVariable Long id) {
        final List<OrderResponseDto> data = orderService.getOrdersByUserId(id);
        return ApiResponse.success(SuccessCode.GET_ORDER_SUCCESS, data);
    }

}
