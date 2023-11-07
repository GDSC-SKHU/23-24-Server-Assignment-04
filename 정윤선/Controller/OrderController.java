package Controller;

import DTO.OrderDTO;
import Domain.Order;
import Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order createOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.createOrder(orderDTO);
    }

    @GetMapping("/{orderId}")
    public OrderDTO getOrder(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId);
    }

    @PutMapping("/{orderId}")
    public Order updateOrder(@PathVariable Long orderId, @RequestBody OrderDTO updatedOrderDTO) {
        return orderService.updateOrder(orderId, updatedOrderDTO);
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
    }
}
