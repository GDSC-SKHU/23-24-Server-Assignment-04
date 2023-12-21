package skhu.gdsc.jpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import skhu.gdsc.jpa.dto.ItemDto;
import skhu.gdsc.jpa.dto.OrderDto;
import skhu.gdsc.jpa.service.OrderService;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/order/new")
    public String createOrder(@RequestBody OrderDto orderDto) {
        return orderService.createOrder(orderDto);
    }

    @GetMapping("/order/{orderId}")
    public OrderDto findeByOrderId(@PathVariable("orderId") Integer orderId) {
        return orderService.findOrderByOrderIdAsDto(orderId);
    }

    @PutMapping("/order")
    public String updateItem(@RequestBody OrderDto orderDto) {
        return orderService.updateOrder(orderDto);
    }

    @DeleteMapping("/order")
    public String deleteItem(@RequestBody OrderDto orderDto) {
        return orderService.deleteOrder(orderDto.getOrderId());
    }
}
