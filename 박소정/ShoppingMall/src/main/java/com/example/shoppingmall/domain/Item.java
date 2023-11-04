package com.example.shoppingmall.domain;

import com.example.shoppingmall.dto.ItemDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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

    @Column(name = "ITEM_COST", nullable = false)
    private Integer cost;

    public ItemDto toDto() {
        return ItemDto.builder()
                .id(this.id)
                .name(this.name)
                .cost(this.cost)
                .build();
    }

    public void update(Item item) {
        this.id = item.id;
        this.name = item.name;
        this.cost = item.cost;
    }
}
