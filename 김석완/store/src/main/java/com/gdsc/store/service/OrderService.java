package com.gdsc.store.service;

import com.gdsc.store.domain.Customer;
import com.gdsc.store.domain.Item;
import com.gdsc.store.domain.Order;
import com.gdsc.store.dto.OrderDto;
import com.gdsc.store.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ItemService itemService;
    private final CustomerService customerService;

    @Transactional
    public String createOrder(OrderDto orderDto){
        Item item = findItemByName(orderDto.getItemName());
        Customer customer = findCustomerByName(orderDto.getCustomerName());

        if(orderDto.getItemName() == null || orderDto.getCustomerName() == null){
            throw new IllegalArgumentException("잘못된 접근입니다.");
        }
        Order.builder()
                .item(item)
                .customer(customer)
                .build();
        return "저장 성공";
    }

    @Transactional
    public List<Order> findAllOrder(){
        return orderRepository.findAll();
    }

    @Transactional
    public Order findOrderById(int orderId){
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 사용자 ID입니다."));
    }

    @Transactional
    public String deleteOrder(int orderId) {
        Order order = findOrderById(orderId);
        orderRepository.delete(order);
        return "삭제 성공";
    }

    private Item findItemById(int itemId){
        return itemService.findItemById(itemId);
    }

    private Item findItemByName(String itemName) { return itemService.findItemByName(itemName);}

    private Customer findCustomerById(int customerId){
        return customerService.findCustomerById(customerId);
    }

    private Customer findCustomerByName(String customerName) {
        return customerService.findCustomerByName(customerName);
    }
}
