package com.example.jpa_exercise.service;

import com.example.jpa_exercise.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import com.example.jpa_exercise.domain.Order;
import com.example.jpa_exercise.dto.OrderDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    @Transactional
    public String createOrder(OrderDto orderDto) {
        Order order = Order.builder()
                .id(orderDto.getId())
                .name(orderDto.getName())
                .price(orderDto.getPrice())
                .build();
        orderRepository.save(order);
        return "저장 성공";
    }

    public Order findOrderByName(String name) {
        return orderRepository.findOrderByName(name)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 주문 이름입니다."));
    }

    @Transactional
    public String updateOrder(OrderDto orderDto) {
        Order order = orderRepository.findById(orderDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("잘못된 주문 ID입니다."));
        order.update(Order.builder()
                .id(orderDto.getId())
                .name(orderDto.getName())
                .price(orderDto.getPrice())
                .build());
        return "수정 성공";
    }

    @Transactional
    public String deleteOrder(OrderDto orderDto) {
        Order order = findOrderByName(orderDto.getName());
        orderRepository.delete(order);
        return "삭제 성공";
    }
}
