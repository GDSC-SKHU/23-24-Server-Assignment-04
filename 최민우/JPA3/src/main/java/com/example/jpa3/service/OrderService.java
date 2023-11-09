package com.example.jpa3.service;

import com.example.jpa3.domain.Customer;
import com.example.jpa3.domain.Item;
import com.example.jpa3.domain.Order;
import com.example.jpa3.dto.OrderDto;
import com.example.jpa3.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ItemService itemService;
    private final CustomerService customerService;


    //Create
    @Transactional
    public String createOrder(OrderDto orderDto) {
        if (orderDto.getCustomerName() == null || orderDto.getItemName() == null) {
            return "주문 실패";
        }
        Order order = toDomain(orderDto);
        orderRepository.save(order);
        return "주문 성공";
    }

    public Order toDomain(OrderDto orderDto) {
        Customer customer = findCustomerByName(orderDto.getCustomerName());
        Item item = findItemByName(orderDto.getItemName());
        return Order.builder()
                .id(orderDto.getId())
                .customer(customer)
                .item(item)
                .build();
    }

    private Customer findCustomerByName(String name) {
        return customerService.findCustomerByName(name);
    }
    private Item findItemByName(String name){
        return itemService.findItemByName(name);
    }

    //Read
    public Order findOrderById(int id){
        return orderRepository.findById(id).orElseThrow(()->new IllegalArgumentException("잘못된 ID입니다."));
    }

    public OrderDto findOrderByIdAsDto(Integer id){
        return findOrderById(id).toDto();
    }

    public List<Order> orderList(){
        return orderRepository.findAll();
    }
}