package com.example.itemcustomerdjpa.service;

import com.example.itemcustomerdjpa.domain.Customer;
import com.example.itemcustomerdjpa.dto.CustomerDTO;
import com.example.itemcustomerdjpa.repository.CustomerRepository;
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
    public String createCustomer(CustomerDTO customerDTO){
        Customer customer = Customer.builder()
                .name(customerDTO.getName())
                .age(customerDTO.getAge())
                .sex(customerDTO.getSex())
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
    public String updateCustomer(CustomerDTO customerDTO){
        Customer customer = customerRepository.findById(customerDTO.getId())
                .orElseThrow(() -> new IllegalArgumentException("잘못된 팀 ID입니다."));
        customer.update(customer.builder()
                        .id(customerDTO.getId())
                        .age(customerDTO.getAge())
                        .name(customerDTO.getName())
                        .sex(customerDTO.getSex())
                .build());
        return "수정 성공";
    }

    //Delete

    /*
    지금 생각해보니까 customerid를 파라미터로 받아서 삭제를 진행해야 했다.
    다 만들고 나서 깨달으니 아쉬운 부분이다.
    다음부턴 기능 하나 만들 때도 신경을 더 써야겠다.
     */
    @Transactional
    public String deleteCustomer(CustomerDTO customerDTO){
        Customer customer = findCustomerByName(customerDTO.getName());
        customerRepository.delete(customer);
        return "삭제 성공";
    }
}
