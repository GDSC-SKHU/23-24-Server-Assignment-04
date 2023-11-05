package com.example.jpa_exercise.domain;

import com.example.jpa_exercise.dto.ItemDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID")
    private Integer id;

    @Column(name = "ITEM_NAME", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    public ItemDto toDto() {
        if (order != null) {
            return ItemDto.builder()
                    .id(this.id)
                    .name(this.name)
                    .orderName(order.getName())
                    .build();
        }
        return ItemDto.builder()
                .id(this.id)
                .name(this.name)
                .build();
    }

    public void update(Item item) {
        this.id = item.id;
        this.name = item.name;
        if (order != null) {
            changeOrder(item.order);
            return;
        }
        this.order = item.order;
    }

    public void changeOrder(Order order) {
        this.order = order;
        order.getItems().add(this);
    }
}
