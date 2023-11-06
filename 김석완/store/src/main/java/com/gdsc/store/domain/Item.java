package com.gdsc.store.domain;

import com.gdsc.store.dto.ItemDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID")
    private int id;
    @Column(name = "ITEM_NAME")
    private String name;
    @Column(name = "ITEM_PRICE")
    private int price;


    public ItemDto toDto() {
        return ItemDto.builder()
                .id(this.id)
                .name(this.name)
                .price(this.price)
                .build();
    }

    public void update(Item item) {
        this.id = item.id;
        this.name = item.name;
        this.price = item.price;
        ;
    }


    public int getId() {
        return this.id;
    }
}