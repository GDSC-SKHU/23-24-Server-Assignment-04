package com.example.buy.domain;

import com.example.buy.dto.ItemDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Item {
    @Id
    @GeneratedValue // (strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID")
    private Long id;

    @Column(name = "ITEM_NAME")
    private String name;

    @Column(name = "ITEM_PIRCE")
    private Integer price;

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
    }

}

