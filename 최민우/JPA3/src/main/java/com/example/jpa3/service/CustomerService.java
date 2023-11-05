package com.example.jpa3.service;

import com.example.jpa3.domain.Customer;
import com.example.jpa3.dto.CustomerDto;
import com.example.jpa3.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    //Create
    @Transactional
    public String createCustomer(CustomerDto customerDto){
        Customer customer = Customer.builder()
                .name(customerDto.getName())
                .age(customerDto.getAge())
                .sex(customerDto.getSex())
                .build();
        customerRepository.save(customer);
        return "저장 성공";
    }

    //Read
    public Customer findCustomerByName(String name) {
        return customerRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 구매자 이름입니다."));
    }
    public Customer findCustomerById(int id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 구매자 ID입니다."));
    }

    public List<Customer> customerList(){
        return customerRepository.findAll();
    }

    //Update
    @Transactional
    public String updateCustomer(CustomerDto customerDto){
        Customer customer = customerRepository.findById(customerDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("잘못된 팀 ID입니다."));
        customer.update(customer.builder()
                .id(customerDto.getId())
                .age(customerDto.getAge())
                .name(customerDto.getName())
                .sex(customerDto.getSex())
                .build());
        return "수정 성공";
    }

    //Delete
    @Transactional
    public String deleteCustomer(CustomerDto customerDto){
        Customer customer = findCustomerByName(customerDto.getName());
        customerRepository.delete(customer);
        return "삭제 성공";
    }
}