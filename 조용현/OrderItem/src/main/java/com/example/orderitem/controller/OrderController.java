package com.example.orderitem.controller;

import com.example.orderitem.domain.Member;
import com.example.orderitem.domain.Order;
import com.example.orderitem.order.dto.AddOrderRequest;
import com.example.orderitem.order.dto.OrderResponse;
import com.example.orderitem.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody @Validated AddOrderRequest addOrderRequest) {
        Order order = orderService.order(addOrderRequest);
        return ResponseEntity.ok(OrderResponse.createInstance(order));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponse> findById(@PathVariable Long orderId) {
        Order findOrder = orderService.findOrderById(orderId);
        return ResponseEntity.ok(OrderResponse.createInstance(findOrder));
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<?> memberDelete(@PathVariable(name = "orderId") Long orderId) {
        orderService.cancelOrder(orderId);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }
}
