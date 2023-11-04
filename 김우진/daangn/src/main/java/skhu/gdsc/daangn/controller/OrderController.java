package skhu.gdsc.daangn.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import skhu.gdsc.daangn.dto.OrderDetailDto;
import skhu.gdsc.daangn.dto.OrderDto;
import skhu.gdsc.daangn.service.CustomerService;
import skhu.gdsc.daangn.service.OrderService;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final CustomerService customerService;

    @PostMapping("/order") //주문하는 api
    public String orderProducts(@RequestBody OrderDetailDto orderDetailDto) {
        Long opCustomerId = orderDetailDto.getCustomerId();
        Long opProductId = orderDetailDto.getProductId();
        Integer opOrderQuantity = orderDetailDto.getOrderQuantity();
        return orderService.orderProducts(opCustomerId, opProductId, opOrderQuantity);
    }

    @GetMapping("/{customerId}/order") //사용자 id를 받아서 주문 정보를 출력
    public OrderDto findOrderInfo(@PathVariable("customerId") Long customerId){
        return customerService.getCustomerOrders(customerId);
    }
}
