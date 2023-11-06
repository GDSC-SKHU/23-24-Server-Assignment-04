package skhu.gdsc.daangn.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import skhu.gdsc.daangn.domain.Customer;
import skhu.gdsc.daangn.domain.Orders;
import skhu.gdsc.daangn.domain.Products;
import skhu.gdsc.daangn.dto.CustomerDto;
import skhu.gdsc.daangn.dto.OrderDto;
import skhu.gdsc.daangn.dto.ProductDto;
import skhu.gdsc.daangn.repository.CustomerRepository;
import skhu.gdsc.daangn.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;

    @Transactional
    public String createCustomer(CustomerDto customerDto){ //사용자 정보 생성
        Customer customer = Customer.builder()
                .customerId(customerDto.getCustomerId())
                .customerName(customerDto.getCustomerName())
                .customerAddress(customerDto.getCustomerAddress())
                .build();

        customerRepository.save(customer);
        return "저장 성공";
    }

    public CustomerDto findCustomerById(Long customerId){ //사용자 정보 조회
        Customer findCustomer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("?"));

        return CustomerDto.builder()
                .customerId(findCustomer.getCustomerId())
                .customerName(findCustomer.getCustomerName())
                .customerAddress(findCustomer.getCustomerAddress())
                .build();
    }


    public OrderDto getCustomerOrders(Long customerId) { //사용자의 주문 정보 호출
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("올바르지 않은 고객ID: " + customerId));

        List<Orders> orders = orderRepository.findByCustomerCustomerId(customerId);

        Products products = orders.get(0).getProducts();

        return OrderDto.builder()
                .customerName(customer.getCustomerName())
                .customerAddress(customer.getCustomerAddress())
                .orderId(orders.get(0).getOrderId())
                .productDto(ProductDto.builder()
                        .productId(products.getProductId())
                        .productName(products.getProductName())
                        .productPrice(products.getProductPrice())
                        .build())
                .totalPurchasePrice((products.getProductPrice() * orders.get(0).getOrderQuantity()))
                .build();
    }

    @Transactional //사용자 정보 수정
    public String updateCustomerInfo(Long customerId, String newName, String newAddress){
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("올바르지 않은 고객ID: " + customerId));
        customer.updateName(newName);
        customer.updateAddress(newAddress);
        return "수정 성공";
    }

    @Transactional
    public String deleteCustomer(Long customerId){ //id입력을 통해 소비자 정보 삭제
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("올바르지 않은 고객ID: " + customerId));
        customerRepository.delete(customer);
        return "삭제 성공";
    }

}
