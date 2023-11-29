package gdsc.skhu.jpaexercise.service;

import gdsc.skhu.jpaexercise.domain.Customer;
import gdsc.skhu.jpaexercise.domain.Item;
import gdsc.skhu.jpaexercise.domain.Order;
import gdsc.skhu.jpaexercise.dto.OrderDto;
import gdsc.skhu.jpaexercise.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository ordersRepository;
    private final ItemService itemService;
    private final CustomerService customerService;

    @Transactional
    public String createOrder(OrderDto orderDto) {
        if (orderDto.getCustomerName() == null || orderDto.getItemName() == null) {
            return "주문 실패했습니다.";
        }
        Order order = toDomain(orderDto);
        ordersRepository.save(order);
        return "주문 성공했습니다.";
    }

    public Order toDomain(OrderDto orderDto) {
        Customer customer = findCustomerByName(orderDto.getCustomerName());
        Item item = findItemByName(orderDto.getItemName());
        return Order.builder()
                .id(orderDto.getId())
                .customer(customer)
                .item(item)
                .build();
    }

    private Customer findCustomerByName(String name) {
        return customerService.findCustomerByName(name);
    }

    private Item findItemByName(String name) {
        return itemService.findItemByName(name);
    }


    public Order findOrderById(int id) {
        return ordersRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("잘못된 ID입니다."));
    }

    public OrderDto findOrderByIdAsDto(Integer id) {
        return findOrderById(id).toDto();
    }

    public List<OrderDto> orderList() {
        return ordersRepository.findAll().stream().map(Order::toDto).toList();
    }
}