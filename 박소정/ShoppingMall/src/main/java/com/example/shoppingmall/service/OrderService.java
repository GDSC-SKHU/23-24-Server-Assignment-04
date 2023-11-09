package com.example.shoppingmall.service;

import com.example.shoppingmall.domain.Customer;
import com.example.shoppingmall.domain.Item;
import com.example.shoppingmall.domain.Order;
import com.example.shoppingmall.dto.OrderDto;
import com.example.shoppingmall.repository.CustomerRepository;
import com.example.shoppingmall.repository.ItemRepository;
import com.example.shoppingmall.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository; // orderService의 CRUD에서 고객과 상품 객체를 사용할 것이므로, 고객 레포지토리 추가
    private final ItemRepository itemRepository;

    @Transactional
    public String createOrder(OrderDto orderDto) {
        Customer customer = customerRepository.findCustomerById(orderDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("해당 고객을 찾을 수 없습니다."));

        Item item = itemRepository.findItemById(orderDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("해당 상품을 찾을 수 없습니다."));

        Order order = Order.builder()
                .customer(customer)
                .item(item)
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
