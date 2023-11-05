package com.example.shoppingmall.controller;

import com.example.shoppingmall.dto.OrderDto;
import com.example.shoppingmall.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/order/new")
    public String createOrder(@RequestBody OrderDto orderDto) {
        return orderService.createOrder(orderDto);
    }

    @GetMapping("/order/{id}")
    public OrderDto findOrderById(@PathVariable("id") Integer id) {
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
