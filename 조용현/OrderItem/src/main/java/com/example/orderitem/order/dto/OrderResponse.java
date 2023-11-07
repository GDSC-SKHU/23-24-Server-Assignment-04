package com.example.orderitem.order.dto;

import com.example.orderitem.domain.*;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.stream.Collectors.toList;

public record OrderResponse(
        Long orderId,
        String name,
        LocalDateTime orderDate,
        OrderStatus orderStatus,
        Address address,
        List<OrderItemDto> orderItems
) {
    public static OrderResponse createInstance(Order order){
        return new OrderResponse(order.getId(), order.getMember().getName(), order.getOrderDate(), order.getStatus(), order.getDelivery().getAddress(),
                order.getOrderItems().stream()
                .map(OrderItemDto::createInstance)
                .collect(toList()));
    }

    public record OrderItemDto(
        String itemName,
        int orderPrice,
        int count
    ){
        public static OrderItemDto createInstance(OrderItem orderItem){
            return new OrderItemDto(orderItem.getItem().getName(), orderItem.getOrderPrice(), orderItem.getCount());
        }
    }
}
