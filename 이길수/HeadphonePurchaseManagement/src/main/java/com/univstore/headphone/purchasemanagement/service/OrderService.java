package com.univstore.headphone.purchasemanagement.service;

import com.univstore.headphone.purchasemanagement.domain.Customer;
import com.univstore.headphone.purchasemanagement.domain.Headphone;
import com.univstore.headphone.purchasemanagement.domain.Order;
import com.univstore.headphone.purchasemanagement.dto.OrderDto;
import com.univstore.headphone.purchasemanagement.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerService customerService;
    private final HeadphoneService headphoneService;

    // CREATE
    @Transactional
    public String createCustomerOrder(OrderDto orderDto) {
        if (orderDto.getCustomerName() == null) {
            Order customerOrder = createOrderWithoutCustomer(orderDto);
            orderRepository.save(customerOrder);
            return "저장 성공";
        }
        Order customerOrder = createOrderWithCustomer(orderDto);
        orderRepository.save(customerOrder);
        return "저장 성공";
    }

    @Transactional
    public String createHeadphoneOrder(OrderDto orderDto) {
        if (orderDto.getHeadphoneName() == null) {
            Order headphoneOrder = createOrderWithoutHeadphone(orderDto);
            orderRepository.save(headphoneOrder);
            return "저장 성공";
        }
        Order headphoneOrder = createOrderWithHeadphone(orderDto);
        orderRepository.save(headphoneOrder);
        return "저장 성공";
    }

    private Order createOrderWithoutCustomer(OrderDto orderDto) {
        return Order.builder()
                .name(orderDto.getName())
                .amount(orderDto.getAmount())
                .date(orderDto.getDate())
                .build();
    }

    private Order createOrderWithoutHeadphone(OrderDto orderDto) {
        return Order.builder()
                .name(orderDto.getName())
                .amount(orderDto.getAmount())
                .date(orderDto.getDate())
                .build();
    }

    private Order createOrderWithCustomer(OrderDto orderDto) {
        Customer customer = findCustomerByName(orderDto.getCustomerName());
        return Order.builder()
                .name(orderDto.getName())
                .amount(orderDto.getAmount())
                .date(orderDto.getDate())
                .customer(customer)
                .build();
    }

    private Order createOrderWithHeadphone(OrderDto orderDto) {
        Headphone headphone = findHeadphoneByName(orderDto.getHeadphoneName());
        return Order.builder()
                .name(orderDto.getName())
                .amount(orderDto.getAmount())
                .date(orderDto.getDate())
                .headphone(headphone)
                .build();
    }

    // READ
    public OrderDto findOrderByNameAsCustomerDto(String ordername) {
        return findOrderByName(ordername).toCustomerDto();
    }

    public OrderDto findOrderByNameAsHeadphoneDto(String ordername) {
        return findOrderByName(ordername).toHeadphoneDto();
    }

    // UPDATE
    @Transactional
    public String updateCustomerOrder(OrderDto orderDto) {
        Order customerOrder = findOrderByName(orderDto.getName());
        if (orderDto.getCustomerName() != null) {
            updateOrderWithCustomer(orderDto, customerOrder);
            orderRepository.save(customerOrder);
            return "수정 성공";
        }
        updateOrderWithoutCustomer(orderDto, customerOrder);
        orderRepository.save(customerOrder);
        return "수정 성공";
    }

    @Transactional
    public String updateHeadphoneOrder(OrderDto orderDto) {
        Order headphoneOrder = findOrderByName(orderDto.getName());
        if (orderDto.getHeadphoneName() != null) {
            updateOrderWithHeadphone(orderDto, headphoneOrder);
            orderRepository.save(headphoneOrder);
            return "수정 성공";
        }
        updateOrderWithoutHeadphone(orderDto, headphoneOrder);
        orderRepository.save(headphoneOrder);
        return "수정 성공";
    }

    private void updateOrderWithCustomer(OrderDto orderDto, Order order) {
        Customer customer = customerService.findCustomerByName(orderDto.getCustomerName());
        order.customerUpdate(Order.builder()
                .id(orderDto.getId())
                .name(orderDto.getName())
                .amount(orderDto.getAmount())
                .date(orderDto.getDate())
                .customer(customer)
                .build());
    }

    private void updateOrderWithHeadphone(OrderDto orderDto, Order order) {
        Headphone headphone = headphoneService.findHeadphoneByName(orderDto.getHeadphoneName());
        order.headphoneUpdate(Order.builder()
                .id(orderDto.getId())
                .name(orderDto.getName())
                .amount(orderDto.getAmount())
                .date(orderDto.getDate())
                .headphone(headphone)
                .build());
    }

    private void updateOrderWithoutCustomer(OrderDto orderDto, Order order) {
        order.customerUpdate(Order.builder()
                .id(orderDto.getId())
                .amount(orderDto.getAmount())
                .date(orderDto.getDate())
                .build());
    }

    private void updateOrderWithoutHeadphone(OrderDto orderDto, Order order) {
        order.headphoneUpdate(Order.builder()
                .id(orderDto.getId())
                .amount(orderDto.getAmount())
                .date(orderDto.getDate())
                .build());
    }

    // DELETE
    @Transactional
    public String deleteOrder(String orderName) {
        Order order = findOrderByName(orderName);
        orderRepository.delete(order);
        return "삭제 성공";
    }

    private Order findOrderByName(String orderName) {
        return orderRepository.findOrderByName(orderName)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 주문명 입니다."));
    }

    private Customer findCustomerByName(String customerName) {
        return customerService.findCustomerByName(customerName);
    }

    private Headphone findHeadphoneByName(String headphoneName) {
        return headphoneService.findHeadphoneByName(headphoneName);
    }
}
