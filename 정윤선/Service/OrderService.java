package Service;

import DTO.OrderDTO;
import Domain.Order;
import Repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(OrderDTO orderDTO) {
        // OrderDTO에서 필요한 데이터를 추출하여 Order 엔티티 생성
        Order order = new Order();
        order.setCustomer(orderDTO.getCustomer());
        order.setItems(orderDTO.getItems());
        order.setOrderDate(orderDTO.getOrderDate());
        // 다른 필드 설정

        // Order 엔티티를 저장하고 반환
        return orderRepository.save(order);
    }

    public OrderDTO getOrderById(Long orderId) {
        // orderId를 사용하여 Order 엔티티 조회
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found"));

        // Order 엔티티를 OrderDTO로 변환
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setCustomer(order.getCustomer());
        orderDTO.setItems(order.getItems());
        orderDTO.setOrderDate(order.getOrderDate());
        // 다른 필드 설정

        return orderDTO;
    }

    public Order updateOrder(Long orderId, OrderDTO updatedOrderDTO) {
        // orderId를 사용하여 Order 엔티티 조회
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found"));

        // updatedOrderDTO에서 필요한 데이터를 추출하여 Order 엔티티 업데이트
        order.setCustomer(updatedOrderDTO.getCustomer());
        order.setItems(updatedOrderDTO.getItems());
        order.setOrderDate(updatedOrderDTO.getOrderDate());
        // 다른 필드 업데이트

        // 업데이트된 Order 엔티티를 저장하고 반환
        return orderRepository.save(order);
    }

    public void deleteOrder(Long orderId) {
        // orderId를 사용하여 Order 엔티티 삭제
        orderRepository.deleteById(orderId);
    }
}
