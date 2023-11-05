package Service;

import DTO.OrderDTO;
import Domain.Order;
import Repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setCustomer(orderDTO.getCustomer());
        order.setItems(orderDTO.getItems());
        order.setOrderDate(orderDTO.getOrderDate());

        return orderRepository.save(order);
    }

    public OrderDTO getOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found"));

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setCustomer(order.getCustomer());
        orderDTO.setItems(order.getItems());
        orderDTO.setOrderDate(order.getOrderDate());

        return orderDTO;
    }

    public Order updateOrder(Long orderId, OrderDTO updatedOrderDTO) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found"));
        order.setCustomer(updatedOrderDTO.getCustomer());
        order.setItems(updatedOrderDTO.getItems());
        order.setOrderDate(updatedOrderDTO.getOrderDate());

        return orderRepository.save(order);
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
