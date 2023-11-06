package com.example.buy.domain;

import com.example.buy.dto.ItemDto;
import com.example.buy.dto.OrderDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "ORDERS_ID")
    private Long id;

    @ManyToOne //단방향 매핑
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @OneToMany
    @JoinColumn(name = "ORDERS_ID")
    private List<Item> items = new ArrayList<>();

    public OrderDto toDto() {
        List<ItemDto> itemDtos = items.stream().map(Item::toDto).toList();
        return OrderDto.builder()
                .id(this.id)
                .customerId(customer.toDto().getId())
                .items(itemDtos)
                .build();
    }

    public void update(Order order) {
        this.id = order.id;
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }
}
