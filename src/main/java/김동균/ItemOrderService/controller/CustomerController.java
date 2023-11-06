package ItemOrderService.controller;

import ItemOrderService.dto.CustomerDto;
import ItemOrderService.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/create")  //  회원 계정 생성
    public String newCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.createCustomer(customerDto);
    }

    // 회원 정보 조회
    @GetMapping("/{customerId}")
    public CustomerDto findCustomerInformation(@PathVariable("customerId") Integer customerId) {
        return customerService.findCustomerInformationByCustomerId(customerId);
    }

    //회원 정보 수정
    @PatchMapping("/{customerId}")
    public String updateCustomerInformation(@PathVariable("customerId") Integer customerId,
                                 @RequestBody CustomerDto customerDto) {
        String name = customerDto.getCustomerName();
        String address = customerDto.getCustomerAddress();
        return customerService.updateCustomerInformation(customerId, name, address);
    }
    // 회원 정보 삭제
    @DeleteMapping("/{customerId}")
    public String deleteCustomer(@PathVariable("customerId") Integer customerId) {
        return customerService.deleteCustomer(customerId);
    }

    // 회원 주문 목록 조회
    @GetMapping("/orderList/{customerId}")
    public String findCustomerOrderList(@PathVariable("customerId") Integer customerId) {
        return customerService.findCustomerOrderList(customerId);
    }
}
