package com.gdsc.ordersystem.service;

import com.gdsc.ordersystem.controller.dto.OrderDetailDto;
import com.gdsc.ordersystem.controller.dto.request.order.OrderCreateRequestDto;
import com.gdsc.ordersystem.controller.dto.response.order.OrderResponseDto;
import com.gdsc.ordersystem.controller.dto.response.product.ProductResponseDto;
import com.gdsc.ordersystem.domain.order.Order;
import com.gdsc.ordersystem.domain.order.OrderDetail;
import com.gdsc.ordersystem.domain.product.Product;
import com.gdsc.ordersystem.domain.user.User;
import com.gdsc.ordersystem.exception.ErrorCode;
import com.gdsc.ordersystem.exception.model.NotFoundException;
import com.gdsc.ordersystem.repository.OrderDetailRepository;
import com.gdsc.ordersystem.repository.OrderRepository;
import com.gdsc.ordersystem.repository.ProductRepository;
import com.gdsc.ordersystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;

    @Transactional
    public OrderResponseDto createOrder(OrderCreateRequestDto requestDto) {
        User user = userRepository.findById(requestDto.getUserId()).orElseThrow(
                () -> new NotFoundException(ErrorCode.NOT_FOUND_USER_EXCEPTION, ErrorCode.NOT_FOUND_USER_EXCEPTION.getMessage())
        );

        Order order = Order.builder()
                .user(user)
                .build();

        for (OrderDetailDto orderDetailDto : requestDto.getOrderDetailDtos()) {
            Product product = productRepository.findById(orderDetailDto.getProductId()).orElseThrow(
                    () -> new NotFoundException(ErrorCode.NOT_FOUND_PRODUCT_EXCEPTION, ErrorCode.NOT_FOUND_PRODUCT_EXCEPTION.getMessage())
            );

            OrderDetail orderDetail = OrderDetail.builder()
                    .quantity(orderDetailDto.getQuantity())
                    .product(product)
                    .build();
            order.addOrderDetail(orderDetail); // 주문에 주문 상세를 추가
        }

        orderRepository.save(order);

        List<OrderDetailDto> orderDetailDtos = new ArrayList<>();
        for (OrderDetail orderDetail : order.getOrderDetails()) {
            orderDetailDtos.add(OrderDetailDto.builder()
                            .productId(orderDetail.getProduct().getId())
                            .productName(orderDetail.getProduct().getName())
                            .quantity(orderDetail.getQuantity())
                    .build());
        }

        return OrderResponseDto.of(
                order.getId(), order.getUser().getId(), order.getUser().getName(), order.getUser().getEmail(),
                order.getCreateAt(), order.getUpdateAt(), orderDetailDtos
        );
    }

    @Transactional
    public List<OrderResponseDto> getOrdersByUserId(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new NotFoundException(ErrorCode.NOT_FOUND_USER_EXCEPTION, ErrorCode.NOT_FOUND_USER_EXCEPTION.getMessage())
        );

        List<Order> orders = orderRepository.findByUser(user);

        List<OrderResponseDto> result = new ArrayList<>();

        for (Order order : orders) {
            List<OrderDetailDto> orderDetailDtos = new ArrayList<>();

            for (OrderDetail orderDetail : order.getOrderDetails()) {
                orderDetailDtos.add(OrderDetailDto.builder()
                        .productId(orderDetail.getProduct().getId())
                        .productName(orderDetail.getProduct().getName())
                        .quantity(orderDetail.getQuantity())
                        .build());
            }

            System.out.println(orderDetailDtos);

             result.add(OrderResponseDto.of(
                    order.getId(), order.getUser().getId(), order.getUser().getName(), order.getUser().getEmail(),
                    order.getCreateAt(), order.getUpdateAt(), orderDetailDtos
            ));
        }

        return result;
    }

}
