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

    public Order findOrderById(Integer id) {
        return orderRepository.findOrderById(id)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 주문번호입니다."));
    }

    @Transactional
    public String updateOrder(OrderDto orderDto) {
        Order order = orderRepository.findOrderById(orderDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("잘못된 주문번호입니다."));
        order.update(Order.builder()
                .id(orderDto.getId())
                .count(orderDto.getCount())
                .build());
        return "수정 성공!";
    }

    @Transactional
    public String deleteOrder(OrderDto orderDto) {
        Order order = findOrderById(orderDto.getId());
        orderRepository.delete(order);
        return "삭제 성공!";
    }
}
