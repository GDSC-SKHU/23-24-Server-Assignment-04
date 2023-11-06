package com.gdsc.store.service;

import com.gdsc.store.domain.Customer;
import com.gdsc.store.dto.CustomerDto;
import com.gdsc.store.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public Customer findCustomerByName(String name) {
        return customerRepository.findCustomerByName(name)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 고객 이름입니다."));
    }

    public Customer findCustomerById(int id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 고객 ID입니다."));
    }

    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }

    @Transactional
    public String updateCustomer(CustomerDto customerDto) {
        Customer customer = customerRepository.findById(customerDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("잘못된 고객 ID입니다."));
        customer.update(customer.builder()
                .id(customerDto.getId())
                .name(customerDto.getName())
                .address(customerDto.getAddress())
                .build());
        return "수정 성공";
    }

    @Transactional
    public String deleteCustomer(CustomerDto customerDto){
        Customer customer = findCustomerById(customerDto.getId());
        customerRepository.delete(customer);
        return "삭제 성공";
    }
}
