package com.univstore.headphone.purchasemanagement.service;

import com.univstore.headphone.purchasemanagement.dto.CustomerDto;
import com.univstore.headphone.purchasemanagement.repository.CustomerRepository;
import com.univstore.headphone.purchasemanagement.domain.Customer;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Transactional
    public String createCustomer(CustomerDto customerDto) {
        Customer customer = Customer.builder()
                .name(customerDto.getName())
                .address(customerDto.getAddress())
                .build();
        customerRepository.save(customer);
        return "저장 성공";
    }

    public Customer findCustomerByName(String customerName) {
        return customerRepository.findCustomerByName(customerName)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 주문자명 입니다."));
    }

    @Transactional
    public String updateCustomer(CustomerDto customerDto) {
        Customer customer = customerRepository.findById(customerDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("잘못된 주문자명 입니다."));
        customer.update(Customer.builder()
                .id(customerDto.getId())
                .name(customerDto.getName())
                .address(customerDto.getAddress())
                .build());
        return "수정 성공";
    }

    @Transactional
    public String deleteCustomer(CustomerDto customerDto) {
        Customer customer = findCustomerByName(customerDto.getName());
        customerRepository.delete(customer);
        return "삭제 성공";
    }
}

