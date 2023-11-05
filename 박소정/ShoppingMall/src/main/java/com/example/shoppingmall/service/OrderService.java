package com.example.shoppingmall.service;

import com.example.shoppingmall.domain.Order;
import com.example.shoppingmall.dto.OrderDto;
import com.example.shoppingmall.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    @Transactional
    public String createOrder(OrderDto orderDto) {
        Order order = Order.builder()
                .count(orderDto.getCount())
                .build();
        orderRepository.save(order);
        return "저장 성공!";
    }
}
