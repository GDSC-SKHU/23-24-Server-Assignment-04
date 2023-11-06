package gdsc.skhu.jpaexercise.controller;

import gdsc.skhu.jpaexercise.dto.CustomerSaveReqDto;
import gdsc.skhu.jpaexercise.dto.OrderSaveReqDto;
import gdsc.skhu.jpaexercise.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customer/save") //사용자 정보 저장
    public ResponseEntity<String> customerSave(@RequestBody CustomerSaveReqDto customerSaveReqDto) {
        customerService.customerSave(customerSaveReqDto);
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }

    @PostMapping("/customer/order") //사용자가 item을 주문
    public ResponseEntity<String> customerOrder(@RequestBody OrderSaveReqDto orderSaveReqDto) {
        customerService.orderSave(orderSaveReqDto);
        return new ResponseEntity<>("상품 주문 성공!", HttpStatus.OK);
    }

}
