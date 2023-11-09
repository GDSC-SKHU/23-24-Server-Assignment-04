package com.gdsc.productapi_v2.Controller;

import com.gdsc.productapi_v2.Service.OrderService;
import com.gdsc.productapi_v2.dto.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class OrderController {
    static OrderService orderService;

    //CREATE
    @PostMapping("/order/new")
    public String createOrder(@RequestBody OrderDTO orderDTO){
        return orderService.createOrder(orderDTO);
    }

    // READ
    @GetMapping("/order/{name}")
    public OrderDTO findOrderByName(String name){
        return orderService.findOrderByName(name).toDto();
    }

    //UPDATE
    @PutMapping("/order")
    public String updateOrder(@RequestBody OrderDTO orderDTO){
        return orderService.updateOrder(orderDTO);
    }

    //DELETE
    @DeleteMapping("/order")
    public String deleteOrder(OrderDTO orderDTO){
        return orderService.deleteOrder(orderDTO);
    }
}
