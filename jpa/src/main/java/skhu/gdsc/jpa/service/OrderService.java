package skhu.gdsc.jpa.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import skhu.gdsc.jpa.domain.Item;
import skhu.gdsc.jpa.domain.Order;
import skhu.gdsc.jpa.dto.OrderDto;
import skhu.gdsc.jpa.repository.OrderRepository;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ItemService itemService;
    private final CustomerService customerService;

    //CREATE
    @Transactional
    public String createOrder(OrderDto orderDto) {
        if (orderDto.getOrderId()== null) {
            Order order = createOrderWithoutItem(orderDto);
            orderRepository.save(order);
            return "저장 성공";
        }
        Order order = createOrderWithItem(orderDto);
        orderRepository.save(order);
        return "저장 성공";
    }

    private Order createOrderWithoutItem(OrderDto orderDto) {
        return Order.builder()
                .orderDate(orderDto.getOrderDate())
                .build();
    }
    private Order createOrderWithItem(OrderDto orderDto) {
        Item item = findByItemId(orderDto.getOrderId());
        return Order.builder()
                .orderDate(orderDto.getOrderDate())
                .item(item)
                .build();
    }

    //READ
    public OrderDto findOrderByOrderIdAsDto(Integer orderId) {
        return findByOrderId(orderId).toDto();
    }

   //UPDATE
    @Transactional
    public String updateOrder(OrderDto orderDto) {
        Order order = findByOrderId(orderDto.getOrderId());
        if(orderDto.getOrderId() != null) {
            updateOrderWithItem(orderDto, order);
            orderRepository.save(order);
            return "수정 성공";
        }
        updateOrderWithoutItem(orderDto, order);
            orderRepository.save(order);
            return "수정 성공";
        }

    //UPDATE
    private void updateOrderWithItem(OrderDto orderDto, Order order) {
        Item item = itemService.findByItemId(orderDto.getItemId());
        order.update(Order.builder()
                .orderId(orderDto.getOrderId())
                .orderDate(orderDto.getOrderDate())
                .item(item)
                .build());
    }

    private void updateOrderWithoutItem(OrderDto orderDto, Order order) {
        order.update(Order.builder()
                .orderId(orderDto.getOrderId())
                .orderDate(orderDto.getOrderDate())
                .build());

    }

    //DELETE
    @Transactional
    public String deleteOrder(Integer orderId) {
        Order order = findByOrderId(orderId);
        orderRepository.delete(order);
        return "삭제 성공";
    }

    private Order findByOrderId(Integer orderId) {
        return orderRepository.findByOrderId(orderId)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 주문 번호입니다."));
    }

    private Item findByItemId(Integer itemId) {
        return itemService.findByItemId(itemId);
    }
}
