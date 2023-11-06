package ItemOrderService.controller;

import ItemOrderService.dto.Dto;
import ItemOrderService.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    // 상품 주문
    @PostMapping("/order")
    public String itemOrderByCustomer(@RequestBody Dto dto) {
        return orderService.itemOrderByCustomer(dto.getCustomerId(), dto.getItemId(), dto.getQuantity());
    }
}
