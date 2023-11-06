package com.gdsc.store.controller;

import com.gdsc.store.domain.Order;
import com.gdsc.store.dto.OrderDto;
import com.gdsc.store.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/order/new")
    public String createOrder(@RequestBody OrderDto orderDto){
        return orderService.createOrder(orderDto);
    }

    @GetMapping("/order")
    public List<Order> findAllOrder(){
        return orderService.findAllOrder();
    }

    @GetMapping("order/{id}")
    public OrderDto findById(@PathVariable("id") int id){
        return orderService.findOrderById(id).toDto();
    }

    @DeleteMapping("/order/{id}")
    public String deleteById(@PathVariable("id") int id) { return orderService.deleteOrder(id);}

}
