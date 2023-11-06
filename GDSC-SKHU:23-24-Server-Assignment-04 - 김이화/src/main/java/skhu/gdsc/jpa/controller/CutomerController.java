package skhu.gdsc.jpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import skhu.gdsc.jpa.domain.Customer;
import skhu.gdsc.jpa.dto.CustomerDto;
import skhu.gdsc.jpa.service.CustomerService;

@RestController
@RequiredArgsConstructor
public class CutomerController {
    private final CustomerService customerService;

    @PostMapping("/customer/new")
    public String createByCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.createCustomer(customerDto);
    }

    @GetMapping("/customer/{customerId}")
    public CustomerDto findByCustomerId(@PathVariable("customerId") Integer customerId) {
        return customerService.findByCustomerId(customerId).toDto();
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
