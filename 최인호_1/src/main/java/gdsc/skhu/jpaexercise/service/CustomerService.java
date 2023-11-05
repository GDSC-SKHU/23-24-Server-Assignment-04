package gdsc.skhu.jpaexercise.service;

import gdsc.skhu.jpaexercise.domain.Customer;
import gdsc.skhu.jpaexercise.domain.Item;
import gdsc.skhu.jpaexercise.domain.Order;
import gdsc.skhu.jpaexercise.dto.CustomerSaveReqDto;
import gdsc.skhu.jpaexercise.dto.OrderSaveReqDto;
import gdsc.skhu.jpaexercise.repository.CustomerRepository;
import gdsc.skhu.jpaexercise.repository.ItemRepository;
import gdsc.skhu.jpaexercise.repository.OrderRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CustomerService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ItemRepository itemRepository;

    public CustomerService(OrderRepository orderRepository, CustomerRepository customerRepository, ItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.itemRepository = itemRepository;
    }

    @Transactional
    public void customerSave(CustomerSaveReqDto customerSaveReqDto) {
        Customer customer = Customer.builder()
                .name(customerSaveReqDto.getName())
                .build();

        customerRepository.save(customer);
    }

    // 상품 주
    @Transactional
    public void orderSave(OrderSaveReqDto orderSaveReqDto) {
        Customer customer = customerRepository.findById(orderSaveReqDto.getCustomerId())
                .orElseThrow();
        Item item = itemRepository.findById(orderSaveReqDto.getItemId())
                .orElseThrow();

        Order order = Order.builder()
                .customer(customer)
                .item(item)
                .build();

        orderRepository.save(order);
    }



}
