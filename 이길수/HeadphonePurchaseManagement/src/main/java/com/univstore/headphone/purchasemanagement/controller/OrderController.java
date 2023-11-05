package com.univstore.headphone.purchasemanagement.controller;

import com.univstore.headphone.purchasemanagement.dto.OrderDto;
import com.univstore.headphone.purchasemanagement.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/order/customer/new")
    public String createCustomerOrder(@RequestBody OrderDto orderDto) {
        return orderService.createCustomerOrder(orderDto);
    }

    @PostMapping("/order/headphone/new")
    public String createHeadphoneOrder(@RequestBody OrderDto orderDto) {
        return orderService.createHeadphoneOrder(orderDto);
    }

    @GetMapping("/order/customer/{name}")
    public OrderDto findCustomerOrder(@PathVariable("name") String name) {
        return orderService.findOrderByNameAsCustomerDto(name);
    }

    @GetMapping("/order/headphone/{name}")
    public OrderDto findHeadphoneOrder(@PathVariable("name") String name) {
        return orderService.findOrderByNameAsHeadphoneDto(name);
    }

    @PutMapping("/order/customer")
    public String updateCustomerOrder(@RequestBody OrderDto orderDto) {
        return orderService.updateCustomerOrder(orderDto);
    }

    @PutMapping("/order/headphone")
    public String updateHeadphoneOrder(@RequestBody OrderDto orderDto) {
        return orderService.updateHeadphoneOrder(orderDto);
    }

    @DeleteMapping("/order")
    public String deleteOrder(@RequestBody OrderDto orderDto) {
        return orderService.deleteOrder(orderDto.getName());
    }
}
