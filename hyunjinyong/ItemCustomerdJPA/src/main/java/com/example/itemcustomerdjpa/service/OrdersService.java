package com.example.itemcustomerdjpa.service;

import com.example.itemcustomerdjpa.domain.Customer;
import com.example.itemcustomerdjpa.domain.Item;
import com.example.itemcustomerdjpa.domain.Orders;
import com.example.itemcustomerdjpa.dto.OrderDTO;
import com.example.itemcustomerdjpa.repository.OrdersRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersService {
    private final OrdersRepository ordersRepository;
    private final ItemService itemService;
    private final CustomerService customerService;


    //Create
    @Transactional
    public String createOrder(OrderDTO orderDTO) {
        if (orderDTO.getCustomerName() == null || orderDTO.getItemName() == null) {
            return "주문 실패";
        }
        Orders orders = toDomain(orderDTO);
        ordersRepository.save(orders);
        return "주문 성공";
    }

    //DTO객체를 Domain객체로 바꾸는 메소드
    public Orders toDomain(OrderDTO orderDTO) {
        Customer customer = findCustomerByName(orderDTO.getCustomerName());
        Item item = findItemByName(orderDTO.getItemName());
        return Orders.builder()
                .id(orderDTO.getId())
                .customer(customer)
                .item(item)
                .build();
    }

    private Customer findCustomerByName(String name) {
        return customerService.findCustomerByName(name);
    }
    private Item findItemByName(String name){
        return itemService.findItemByName(name);
    }



    //Read
    //id로 order테이블을 검색하는 메소드
    public Orders findOrderById(int id){
        return ordersRepository.findById(id).orElseThrow(()->new IllegalArgumentException("잘못된 ID입니다."));
    }

    public OrderDTO findOrderByIdAsDto(Integer id){
        return findOrderById(id).toDto();
    }

    public List<Orders> orderList(){
        return ordersRepository.findAll();
    }
}