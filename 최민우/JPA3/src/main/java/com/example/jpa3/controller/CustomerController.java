package com.example.jpa3.controller;

import com.example.jpa3.domain.Customer;
import com.example.jpa3.dto.CustomerDto;
import com.example.jpa3.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/customer")
    public List<Customer> cusFindAll(){
        return customerService.customerList();
    }
    @GetMapping("/customer/{name}")
    public CustomerDto findCustomerByName(@PathVariable("name") String name){
        return customerService.findCustomerByName(name).toDto();
    }

    @PostMapping("/customer/new")
    public String createCustomer(@RequestBody CustomerDto customerDto){
        return customerService.createCustomer(customerDto);
    }

    @PutMapping("/customer")
    public String updateCustomer(@RequestBody CustomerDto customerDto){
        return customerService.updateCustomer(customerDto);
    }

    @DeleteMapping("/customer")
    public String deleteCustomer(@RequestBody CustomerDto customerDto){
        return customerService.deleteCustomer(customerDto);
    }
}