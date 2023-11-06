package com.example.orderitem.order.dto;

import com.example.orderitem.domain.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.aspectj.weaver.ast.Or;

import java.time.LocalDateTime;

public record AddOrderRequest (
    @NotNull
    Long memberId,
    @NotNull
    Long itemId,
    @NotNull
    Integer count
){
    public Order toEntity(Member member, Delivery delivery, OrderItem... orderItems) {
        Order order = Order.builder()
                .member(member)
                .delivery(delivery)
                .orderDate(LocalDateTime.now())
                .status(OrderStatus.ORDER)
                .build();
        for (OrderItem orderItem : orderItems) {
            order.addOrderItem(orderItem);
        }
        return order;
    }
}
