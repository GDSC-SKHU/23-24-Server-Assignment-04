package gdsc.skhu.jpaexercise.service;

import gdsc.skhu.jpaexercise.domain.Customer;
import gdsc.skhu.jpaexercise.domain.Order;
import gdsc.skhu.jpaexercise.dto.OrderResDto;
import gdsc.skhu.jpaexercise.repository.CustomerRepository;
import gdsc.skhu.jpaexercise.repository.ItemRepository;
import gdsc.skhu.jpaexercise.repository.OrderRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    

    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    // 회원아이디로 item 찾기
    public List<OrderResDto> customerItemList(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow();

        List<Order> orderList = orderRepository.findByCustomer(customer);

        List<OrderResDto> orderResDtos = new ArrayList<>();
        for (Order order : orderList) {
            OrderResDto orderResDto = new OrderResDto(order.getItem().getId(),
                    order.getItem().getName(),
                    order.getItem().getPrice());

            orderResDtos.add(orderResDto);
        }

        return orderResDtos;
    }

}
