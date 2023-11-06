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
    public OrderDto findeByOrderId(@PathVariable("itemId") Integer itemId) {
        return orderService.findOrderByOrderIdAsDto(orderId).toDto();
    }

    @PutMapping("/order")
    public String updateItem(@RequestBody ItemDto itemDto) {
        return orderService.updateOrder(orderDto);
    }

    @DeleteMapping("/order")
    public String deleteItem(@RequestBody ItemDto itemDto) {
        return orderService.deleteOrder(orderDto);
    }
}
