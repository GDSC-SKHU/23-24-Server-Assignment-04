package gdsc.skhu.jpaexercise.controller;


import gdsc.skhu.jpaexercise.domain.Customer;
import gdsc.skhu.jpaexercise.dto.CustomerDto;
import gdsc.skhu.jpaexercise.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/customer")
    public List<Customer> customerFindAll() {
        return customerService.customerList();
    }

    @PostMapping("/customer/new")
    public String createCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.createCustomer(customerDto);
    }

    @GetMapping("/customer/{name}")
    public CustomerDto findCustomerByName(@PathVariable("name") String name) {
        return customerService.findCustomerByName(name).toDto();
    }

    @PutMapping("/customer")
    public String updateCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.updateCustomer(customerDto);
    }

    @DeleteMapping("/customer/{id}")
    public String deleteCustomer(@PathVariable("id") Integer id) {
        return customerService.deleteCustomer(id);
    }
}
