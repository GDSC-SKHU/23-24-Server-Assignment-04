package com.example.jpa_exercise.service;

import com.example.jpa_exercise.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import com.example.jpa_exercise.domain.Orders;
import com.example.jpa_exercise.dto.OrderDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    @Transactional
    public String createOrder(OrderDto orderDto) {
        Orders orders = Orders.builder()
                .name(orderDto.getName())
                .price(orderDto.getPrice())
                .build();
        orderRepository.save(orders);
        return "저장 성공";
    }

    public Orders findOrderByName(String name) {
        return orderRepository.findOrderByName(name)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 주문 이름입니다."));
    }

    @Transactional
    public String updateOrder(OrderDto orderDto) {
        Orders orders = orderRepository.findById(orderDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("잘못된 주문 ID입니다."));
        orders.update(Orders.builder()
                .id(orderDto.getId())
                .name(orderDto.getName())
                .price(orderDto.getPrice())
                .build());
        return "수정 성공";
    }

    @Transactional
    public String deleteOrder(OrderDto orderDto) {
        Orders orders = findOrderByName(orderDto.getName());
        orderRepository.delete(orders);
        return "삭제 성공";
    }
}
