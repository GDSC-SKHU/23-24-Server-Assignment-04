package gdsc.example.sales.service;

import gdsc.example.sales.domain.Customer;
import gdsc.example.sales.domain.Order;
import gdsc.example.sales.domain.Product;
import gdsc.example.sales.dto.OrderDto;
import gdsc.example.sales.repository.CustomerRepository;
import gdsc.example.sales.repository.OrderRepository;
import gdsc.example.sales.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    @Transactional
    public String createOrder(OrderDto orderDto) {
        Customer customer = customerRepository.findCustomerById(orderDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("잘못된 고객 Id입니다."));

        Product product = productRepository.findProductById(orderDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("잘못된 상품 Id입니다."));

        Order order = Order.builder()
                .customer(customer)
                .product(product)
                .quantity(orderDto.getQuantity())
                .build();
        orderRepository.save(order);
        return "저장완료";
    }

    public Order findOrderById(Integer id) {
        return orderRepository.findOrderById(id)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 주문 Id입니다."));
    }

    @Transactional
    public String updateOrder(OrderDto orderDto) {
        Order order = orderRepository.findOrderById(orderDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("잘못된 주문 Id입니다."));
        order.update(Order.builder()
                .id(orderDto.getId())
                .quantity(orderDto.getQuantity())
                .build());
        return "수정완료";
    }

    @Transactional
    public String deleteOrder(OrderDto orderDto) {
        Order order = findOrderById(orderDto.getId());
        orderRepository.delete(order);
        return "삭제완료";
    }
}
