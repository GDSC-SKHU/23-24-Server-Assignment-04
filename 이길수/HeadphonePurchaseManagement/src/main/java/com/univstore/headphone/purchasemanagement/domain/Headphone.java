package com.univstore.headphone.purchasemanagement.domain;

import com.univstore.headphone.purchasemanagement.dto.HeadphoneDto;
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
public class Headphone {
    @Id @GeneratedValue
    @Column(name = "HEADPHONE_ID")
    private Integer id;

    @Column(name = "HEADPH0NE_BRAND", nullable = false)
    private String brand;

    @Column(name = "HEADPH0NE_NAME", nullable = false)
    private String name;

    @Column(name = "HEADPH0NE_PRICE", nullable = false)
    private Integer price;

    @OneToMany(mappedBy = "headphone")
    @Column(name = "HEADPHONE_ORDERS")
    private List<Order> orders = new ArrayList<>();

    public HeadphoneDto toHeadphoneDto() {
        List<OrderDto> orderDtos = orders.stream().map(Order::toHeadphoneDto).toList();
        return HeadphoneDto.builder()
                .id(this.id)
                .brand(this.brand)
                .name(this.name)
                .price(this.price)
                .orders(orderDtos)
                .build();
    }

    public void update(Headphone headphone) {
        this.id = headphone.id;
        this.brand = headphone.brand;
        this.name = headphone.name;
        this.price = headphone.price;
    }

    public List<Order> getOrders() {
        return Collections.unmodifiableList(orders);
    }

    public String getName() {
        return this.name;
    }
}
