package skhu.gdsc.daangn.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import skhu.gdsc.daangn.dto.CustomerDto;
import skhu.gdsc.daangn.dto.CustomerModifyDto;
import skhu.gdsc.daangn.service.CustomerService;

@RestController
@RequiredArgsConstructor
@RequestMapping("customer")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/new") //사용자 정보 입력
    public String newCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.createCustomer(customerDto);
    }

    @GetMapping("/{customerId}") // 사용자 정보 조회
    public CustomerDto findCustomer(@PathVariable("customerId") Long customerId) {
        return customerService.findCustomerById(customerId);
    }


    @PatchMapping("/{customerId}") //사용자 정보 수정
    public String updateCustomer(@PathVariable("customerId") Long customerId,
                                 @RequestBody CustomerModifyDto customerModifyDto) {
        String newName = customerModifyDto.getCustomerName();
        String newAddress = customerModifyDto.getCustomerAddress();
        return customerService.updateCustomerInfo(customerId, newName, newAddress);
    }

    @DeleteMapping("/{customerId}") //사용자 정보 삭제
    public String deleteCustomer(@PathVariable("customerId") Long customerId){
        return customerService.deleteCustomer(customerId);
    }
}
