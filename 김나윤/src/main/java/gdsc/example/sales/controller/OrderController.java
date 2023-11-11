package gdsc.example.sales.controller;

import gdsc.example.sales.dto.OrderDto;
import gdsc.example.sales.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("new")
    public String createOrder(@RequestBody OrderDto orderDto) {
        return orderService.createOrder(orderDto);
    }

    @GetMapping("{id}")
    public OrderDto findOrderById(@PathVariable("id") Integer id) {
        return orderService.findOrderById(id).toDto();
    }

    @PutMapping
    public String updateOrder(@RequestBody OrderDto orderDto) {
        return orderService.updateOrder(orderDto);
    }

    @DeleteMapping
    public String deleteOrder(@RequestBody OrderDto orderDto) {
        return orderService.deleteOrder(orderDto);
    }
}


}
