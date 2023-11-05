package com.example.jpa3.controller;

import com.example.jpa3.domain.Order;
import com.example.jpa3.dto.OrderDto;
import com.example.jpa3.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/order")
    public List<Order> orderList(){
        return orderService.orderList();
    }

    @GetMapping("/order/{id}")
    public OrderDto findById(@PathVariable("id") int id){
        return orderService.findOrderByIdAsDto(id);
    }

    @PostMapping("/order/new")
    public String createOrder(@RequestBody OrderDto orderDto){
        return orderService.createOrder(orderDto);
    }
}