package com.example.itemcustomerdjpa.controller;

import com.example.itemcustomerdjpa.domain.Customer;
import com.example.itemcustomerdjpa.dto.CustomerDTO;
import com.example.itemcustomerdjpa.service.CustomerService;
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
    public CustomerDTO findCustomerByName(@PathVariable("name") String name){
        return customerService.findCustomerByName(name).toDto();
    }

    @PostMapping("/customer/new")
    public String createCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.createCustomer(customerDTO);
    }

    @PutMapping("/customer")
    public String updateCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.updateCustomer(customerDTO);
    }

    @DeleteMapping("/customer")
    public String deleteCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.deleteCustomer(customerDTO);
    }

}
