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
        return "저장 성공!";
    }

    private Customer createCustomerData(CustomerDto customerDto) {
        return Customer.builder()
                .name(customerDto.getName())
                .phoneNumber(customerDto.getPhoneNumber())
                .address(customerDto.getAddress())
                .build();
    }

    // READ
    public CustomerDto findCustomerByNameAsDto(String customername) {
        return findCustomerByName(customername).toDto();
    }

    // UPDATE
    @Transactional
    public String updateCustomer(CustomerDto customerDto) {
        Customer customer = findCustomerByName(customerDto.getName());
        updateCustomer(customerDto, customer);
        customerRepository.save(customer);
        return "수정 성공!";
    }

    private void updateCustomer(CustomerDto customerDto, Customer customer) {
        customer.update(Customer.builder()
                .id(customerDto.getId())
                .name(customerDto.getName())
                .phoneNumber(customerDto.getPhoneNumber())
                .address(customerDto.getAddress())
                .build());
    }

    private Customer findCustomerByName(String customername) {
        return customerRepository.findCustomerByName(customername)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 고객 이름입니다."));
    }
}
