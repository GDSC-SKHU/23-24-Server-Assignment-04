package ItemOrderService.service;

import ItemOrderService.domain.Customer;
import ItemOrderService.domain.Order;
import ItemOrderService.dto.CustomerDto;
import ItemOrderService.repository.CustomerRepository;
import ItemOrderService.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;

    // 회원가입 메소드
    @Transactional
    public String createCustomer(CustomerDto customerDto)  {
        Customer customer = Customer.builder()
                .customerId(customerDto.getCustomerId())
                .customerName(customerDto.getCustomerName())
                .customerAddress(customerDto.getCustomerAddress())
                .build();
        customerRepository.save(customer);

        return "회원가입이 완료되었습니다.";
    }

    // 회원 정보 조회 메소드
    public CustomerDto findCustomerInformationByCustomerId(Integer customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자 ID입니다"));

        return CustomerDto.builder()
                .customerId(customer.getCustomerId())
                .customerName(customer.getCustomerName())
                .customerAddress(customer.getCustomerAddress())
                .build();
    }

    // 회원 정보 수정 메소드
    @Transactional
    public String updateCustomerInformation(Integer customerId, String name, String address) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자 ID입니다"));
        customer.updateCustomerInformation(name, address);
        return "수정이 완료되었습니다.";
    }

    // 회원 정보 삭제 메소드
    @Transactional
    public String deleteCustomer(Integer customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자 ID입니다"));
        customerRepository.delete(customer);
        return "탈퇴가 완료되었습니다.";
    }

    // 회원 주문 목록 조회 메소드
    public String findCustomerOrderList(Integer customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자 ID입니다"));
        List<Order> orderList = new ArrayList<>(orderRepository.findByCustomer(customer));

        for (Order order : orderList) {
            return "주문 날짜 : " + order.getOrderDate() + ",상품 이름 : " + order.getItem().getItemName() + "\n";
        }
        return "";
    }

}
