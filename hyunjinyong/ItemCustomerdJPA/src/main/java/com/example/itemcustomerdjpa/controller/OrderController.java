package com.example.itemcustomerdjpa.controller;

import com.example.itemcustomerdjpa.domain.Orders;
import com.example.itemcustomerdjpa.dto.OrderDTO;
import com.example.itemcustomerdjpa.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrdersService ordersService;

    @GetMapping("/order")
    public List<Orders> orderList(){
        return ordersService.orderList();
    }

    @GetMapping("/order/{id}")
    public OrderDTO findById(@PathVariable("id") int id){
        return ordersService.findOrderByIdAsDto(id);
    }

    @PostMapping("/order/new")
    public String createOrder(@RequestBody OrderDTO orderDTO){
        return ordersService.createOrder(orderDTO);
    }
}
