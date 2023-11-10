package gdsc.example.sales.controller;

import gdsc.example.sales.dto.CustomerDto;
import gdsc.example.sales.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("customer")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("new")
    public String createCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.createCustomer(customerDto);
    }

    @GetMapping("{id}")
    public CustomerDto findCustomer(@PathVariable("id") Integer customerId) {
        return customerService.findCustomerByIdAsDto(customerId);
    }

    @PutMapping
    public String upadteCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.updateCustomer(customerDto);
    }

    @DeleteMapping
    public String deleteCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.deleteCustomer(customerDto.getId());
    }
}
