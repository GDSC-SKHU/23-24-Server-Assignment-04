package com.example.jpa_exercise.domain;

import com.example.jpa_exercise.dto.ItemDto;
import com.example.jpa_exercise.dto.OrderDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    private Integer id;

    @Column(name = "ORDER_NAME", nullable = false)
    private String name;

    @Column(name = "ORDER_PRICE", nullable = false)
    private Integer price;

    @OneToMany(mappedBy = "order")
    @Column(name = "ORDER_ITEMS")
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

    public void update(Order order) {
        this.id = order.id;
        this.name = order.name;
        this.price = order.price;
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }

    public String getName() {
        return this.name;
    }
}
