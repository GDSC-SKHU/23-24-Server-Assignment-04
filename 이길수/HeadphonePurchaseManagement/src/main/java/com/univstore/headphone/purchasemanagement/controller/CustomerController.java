package com.univstore.headphone.purchasemanagement.controller;

import com.univstore.headphone.purchasemanagement.dto.CustomerDto;
import com.univstore.headphone.purchasemanagement.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/customer/new")
    public String createCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.createCustomer(customerDto);
    }

    @GetMapping("/customer/{name}")
    public CustomerDto findCustomerByName(@PathVariable("name") String name) {
        return customerService.findCustomerByName(name).toCustomerDto();
    }

    @PutMapping("/customer")
    public String updateCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.updateCustomer(customerDto);
    }

    @DeleteMapping("/customer")
    public String deleteCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.deleteCustomer(customerDto);
    }
}
