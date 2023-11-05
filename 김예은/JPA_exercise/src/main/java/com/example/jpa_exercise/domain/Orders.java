package com.example.jpa_exercise.domain;

import com.example.jpa_exercise.dto.ItemDto;
import com.example.jpa_exercise.dto.OrderDto;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

    @Id
    @GeneratedValue
    @Column(name = "ORDERS_ID")
    private Integer id;

    @Column(name = "ORDERS_NAME", nullable = false)
    private String name;

    @Column(name = "ORDERS_PRICE")
    private int price;

    @OneToMany
    @JoinColumn(name ="ORDERS_ID")
    private List<Item> items = new ArrayList<>();

    public OrderDto toDto() {
        List<ItemDto> itemDtos = items.stream().map(Item::toDto).toList();
        return OrderDto.builder()
                .id(this.id)
                .name(this.name)
                .price(this.price)
                .items(itemDtos)
                .build();
    }

    public void update(Orders orders) {
        this.id = orders.id;
        this.name = orders.name;
        this.price = orders.price;
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }

    public String getName() {
        return this.name;
    }
}
