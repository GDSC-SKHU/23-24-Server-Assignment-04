package skhu.gdsc.jpa.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import skhu.gdsc.jpa.domain.Customer;
import skhu.gdsc.jpa.dto.CustomerDto;
import skhu.gdsc.jpa.repository.CustomerRepository;


@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Transactional
    public String createCustomer(CustomerDto customerDto) {
        Customer customer = Customer.builder()
                .customerId(customerDto.getCustomerId())
                .build();
        customerRepository.save(customer);
        return "저장 성공";
    }

    public Customer findByCustomerId(Integer customerId) {
        return customerRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 고객 번호입니다."));
    }

    @Transactional
    public String updateCustomer(CustomerDto customerDto) {
        Customer customer = customerRepository.findByCustomerId(customerDto.getCustomerId())
                .orElseThrow(() -> new IllegalArgumentException("잘못된 고객 번호입니다."));
        customer.update(Customer.builder()
                .customerId(customerDto.getCustomerId())
                .customerName(customerDto.getCustomerName())
                .customerAddress(customerDto.getCustomerAddress())
                .build());
        return "수정 성공";
    }

    @Transactional
    public String deleteCustomer(CustomerDto customerDto) {
        Customer customer = findByCustomerId(customerDto.getCustomerId());
        customerRepository.delete(customer);
        return "삭제 성공";
    }
}

