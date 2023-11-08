package com.example.buy.service;

import com.example.buy.domain.Customer;
import com.example.buy.domain.Item;
import com.example.buy.domain.Order;
import com.example.buy.dto.OrderDto;
import com.example.buy.repository.CustomerRepository;
import com.example.buy.repository.ItemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.buy.repository.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ItemRepository itemRepository;

    @Transactional
    public String createOrder(OrderDto orderDto) {
        // 고객 찾기
        Customer customer = customerRepository.findById(orderDto.getCustomerId())
                .orElseThrow(() -> new IllegalArgumentException("잘못된 고객 ID 입니다."));
        List<Long> itemIds = orderDto.getItemIds(); // 수정한 부분
        List<Item> items = itemRepository.findAllById(itemIds);

        Order order = Order.builder()
                .customer(customer)
                .items(items)
                .build();

        orderRepository.save(order);
        return "주문 성공";
    }


    public Order findOrderById(Long id) {
        return orderRepository.findOrderById(id)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 주문 ID 입니다."));
    }

    @Transactional
    public String updateOrder(OrderDto orderDto) {
        Order order = orderRepository.findOrderById(orderDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("잘못된 주문 ID 입니다."));
        order.update(Order.builder()
                .id(orderDto.getId())
                .build());
        return "수정 성공!";
    }

    @Transactional
    public String deleteOrder(OrderDto orderDto) {
        Order order = findOrderById(orderDto.getId());
        orderRepository.delete(order);
        return "삭제 성공";
    }
}
