package com.gdsc.store.controller;

import com.gdsc.store.domain.Customer;
import com.gdsc.store.dto.CustomerDto;
import com.gdsc.store.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/customer/new")
    public String createCustomer(@RequestBody CustomerDto customerDto){
        return customerService.createCustomer(customerDto);
    }

    @GetMapping("/customer/{id}")
    public CustomerDto findCustomerById(@PathVariable("id") int id){
        return customerService.findCustomerById(id).toDto();
    }

    @GetMapping("/customer")
    public List<Customer> findAllCustomer(){
        return customerService.findAllCustomer();
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

