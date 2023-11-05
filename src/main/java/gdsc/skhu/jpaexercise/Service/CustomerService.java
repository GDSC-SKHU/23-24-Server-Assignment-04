package com.gdsc.productapi_v2.Service;

import com.gdsc.productapi_v2.Repositiory.CustomerRepository;
import com.gdsc.productapi_v2.domain.Customer;
import com.gdsc.productapi_v2.dto.CustomerDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    //CREATE / 고객 생성
    @Transactional
    public String createCustomer(CustomerDTO customerDTO){
        Customer customer = Customer.builder()
                .name(customerDTO.getName())
                .build();
        return "고객 생성";
    }
    // 고객 조회
    @Transactional
    public Customer findCustomerByName(String name){
        return customerRepository.findCustomerByName(name)
                .orElseThrow(()->new IllegalArgumentException("잘못된 이름입니다."));
    }

    // 고객 삭제
    @Transactional
    public String deleteCustomer(CustomerDTO customerDTO){
        Customer customer = findCustomerByName(customerDTO.getName());
        customerRepository.delete(customer);
        return "고객 삭제";
    }

}
