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
    public CustomerDto findCustomerByIdAsDto(Integer customerId) {
        return findCustomerById(customerId).toDto();
    }

    // UPDATE
    @Transactional
    public String updateCustomer(CustomerDto customerDto) {
        Customer customer = findCustomerById(customerDto.getId());
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

    // DELETE
    @Transactional
    public String deleteCustomer(Integer customerId) {
        Customer customer = findCustomerById(customerId);
        customerRepository.delete(customer);
        return "삭제 성공!";
    }

    private Customer findCustomerById(Integer customerId) {
        return customerRepository.findCustomerById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 고객ID입니다."));
    }
}
