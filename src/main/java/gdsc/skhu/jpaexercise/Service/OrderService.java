package com.gdsc.productapi_v2.Service;

import com.gdsc.productapi_v2.Repositiory.OrderRepository;
import com.gdsc.productapi_v2.domain.Order;
import com.gdsc.productapi_v2.dto.OrderDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    @Transactional
    public String createOrder(OrderDTO orderDTO){
        Order order = Order.builder()
                .name(orderDTO.getOrdername())
                .build();
        orderRepository.save(order);
        return "저장 완료!";
    }

    public Order findOrderByName(String name){
        return orderRepository.findOrderByName(name)
                .orElseThrow(()->new IllegalArgumentException("잘못된 이름입니다."));
    }
    @Transactional
    public String updateOrder(OrderDTO orderDTO){
        Order order = orderRepository.findById(orderDTO.getId())
                .orElseThrow(()->new IllegalArgumentException("잘못된 ORDER ID입니다."));
        order.update(Order.builder()
                .id(orderDTO.getId())
                .name(orderDTO.getOrdername())
                .build());
        return "수정 완료";
    }

    @Transactional
    public String deleteOrder(OrderDTO orderDTO){
        Order order = findOrderByName(orderDTO.getOrdername());
        orderRepository.delete(order);
        return "삭제 완료";
    }
}
