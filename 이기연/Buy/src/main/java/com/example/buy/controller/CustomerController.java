package com.example.buy.controller;

import com.example.buy.dto.CustomerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.buy.service.CustomerService;

@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/customer/new")
    public String createCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.createCustomer(customerDto);
    }

    @GetMapping("/customer/{id}")
    public CustomerDto findCustomer(@PathVariable("id") Long id) {
        return customerService.findCustomerByIdAsDto(id);
    }

    @PutMapping("/customer")
    public String updateCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.updateCustomer(customerDto);
    }

    @DeleteMapping("/customer")
    public String deleteCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.deleteCustomer(customerDto.getId());
    }
}
