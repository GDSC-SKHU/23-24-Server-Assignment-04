package com.example.shoppingmall.service;

import com.example.shoppingmall.domain.Customer;
import com.example.shoppingmall.dto.CustomerDto;
import com.example.shoppingmall.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    // CREATE
    @Transactional // 트랜잭션 처리
    public String createCustomer(CustomerDto customerDto) {
        Customer customer = createCustomerData(customerDto);
        customerRepository.save(customer);
        return "저장 성공";
    }

    private Customer createCustomerData(CustomerDto customerDto) {
        return Customer.builder()
                .name(customerDto.getName())
                .phoneNumber(customerDto.getPhoneNumber())
                .address(customerDto.getAddress())
                .build();
    }
}
