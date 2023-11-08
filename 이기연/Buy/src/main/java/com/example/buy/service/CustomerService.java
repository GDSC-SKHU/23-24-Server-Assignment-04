package com.example.buy.service;

import com.example.buy.domain.Customer;
import com.example.buy.dto.CustomerDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.buy.repository.CustomerRepository;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    // CREATE
    @Transactional
    public String createCustomer(CustomerDto customerDto) {
        Customer customer = createCustomerData(customerDto);
        customerRepository.save(customer);
        return "저장 성공";
    }

    private Customer createCustomerData(CustomerDto customerDto) {
        return Customer.builder()
                .id(customerDto.getId())
                .name(customerDto.getName())
                .build();
    }

    // READ
    public CustomerDto findCustomerByIdAsDto(Long customerId) {
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
                .build());
    }

    // DELETE
    @Transactional
    public String deleteCustomer(Long customerId) {
        Customer customer = findCustomerById(customerId);
        customerRepository.delete(customer);
        return "삭제 성공";
    }

    private Customer findCustomerById(Long customerId) {
        return customerRepository.findCustomerById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 ID입니다."));
    }
}
