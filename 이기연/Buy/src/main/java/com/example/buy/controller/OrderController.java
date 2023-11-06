package com.example.buy.controller;

import com.example.buy.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import com.example.buy.service.OrderService;

@Service
@RestController
@RequiredArgsConstructor

public class OrderController {
    private final OrderService orderService;

    @PostMapping("/order/new")
    public String createOrder(@RequestBody OrderDto orderDto) {
        return orderService.createOrder(orderDto);
    }

    @GetMapping("/order/{id}")
    public OrderDto findOrderById(@PathVariable("id") Long id) {
        return orderService.findOrderById(id).toDto();
    }

    @PutMapping("/order")
    public String updateOrder(@RequestBody OrderDto orderDto) {
        return orderService.updateOrder(orderDto);
    }

    @DeleteMapping("/order")
    public String deleteOrder(@RequestBody OrderDto orderDto) {
        return orderService.deleteOrder(orderDto);
    }
}