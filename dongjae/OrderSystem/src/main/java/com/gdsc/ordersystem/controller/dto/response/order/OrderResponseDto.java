package com.gdsc.ordersystem.controller.dto.response.order;

import com.gdsc.ordersystem.controller.dto.OrderDetailDto;
import com.gdsc.ordersystem.domain.order.Order;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderResponseDto {

    private Long orderId;
    private Long userId;
    private String userName;
    private String userEmail;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private List<OrderDetailDto> orderDetails;

    public static OrderResponseDto of(
            Long orderId, Long userId, String userName, String userEmail, LocalDateTime createAt, LocalDateTime updateAt, List<OrderDetailDto> orderDetails
    ) {
        return new OrderResponseDto(orderId, userId, userName, userEmail, createAt, updateAt, orderDetails);
    }
}
