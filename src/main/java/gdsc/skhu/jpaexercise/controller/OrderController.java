package gdsc.skhu.jpaexercise.controller;

import gdsc.skhu.jpaexercise.dto.OrderResDto;
import gdsc.skhu.jpaexercise.service.OrderService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order/list") //사용자가 무슨 item을 주문했는지 출력
    public ResponseEntity<List<OrderResDto>> orderList(@RequestParam("customerId") Long customerId) {
        List<OrderResDto> orderResDtos = orderService.customerItemList(customerId);
        return new ResponseEntity<>(orderResDtos, HttpStatus.OK);
    }
}
