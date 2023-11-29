package gdsc.skhu.jpaexercise.controller;

import gdsc.skhu.jpaexercise.domain.Order;
import gdsc.skhu.jpaexercise.dto.OrderDto;
import gdsc.skhu.jpaexercise.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    @Autowired
    private final OrderService orderService;

    @GetMapping("/order")
    public List<OrderDto> orderList() {
        return orderService.orderList();
    }

    @GetMapping("/order/{id}")
    public Order findOrderById(@PathVariable("id") Integer id) {
        return orderService.findOrderById(id);
    }

    @PostMapping("/order/new")
    public String createOrder(@RequestBody OrderDto orderDto) {
        return orderService.createOrder(orderDto);
    }
}



