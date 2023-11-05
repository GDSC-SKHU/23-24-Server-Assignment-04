package com.univstore.headphone.purchasemanagement.domain;

import com.univstore.headphone.purchasemanagement.dto.CustomerDto;
import com.univstore.headphone.purchasemanagement.dto.OrderDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id @GeneratedValue
    @Column(name = "CUSTOMER_ID")
    private Integer id;

    @Column(name = "CUSTOMER_NAME", nullable = false)
    private String name;

    @Column(name = "CUSTOMER_ADDRESS", nullable = false)
    private String address;

    @OneToMany(mappedBy = "customer")
    @Column(name = "CUSTOMER_ORDERS")
    private List<Order> orders = new ArrayList<>();

    public CustomerDto toCustomerDto() {
        List<OrderDto> orderDtos = orders.stream().map(Order::toCustomerDto).toList();
        return CustomerDto.builder()
                .id(this.id)
                .name(this.name)
                .address(this.address)
                .orders(orderDtos)
                .build();
    }

    public void update(Customer customer) {
        this.id = customer.id;
        this.name = customer.name;
        this.address = customer.address;
    }

    public List<Order> getOrders() {
        return Collections.unmodifiableList(orders);
    }

    public String getName() {
        return this.name;
    }
}
