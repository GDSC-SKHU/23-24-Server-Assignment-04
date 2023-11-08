package com.example.itemcustomerdjpa.domain;

import com.example.itemcustomerdjpa.dto.ItemDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID")
    Integer id;

    @Column(name = "ITEM_NAME", nullable = false)
    String name;

    @Column(name = "ITEM_PRICE", nullable = false)
    int price;


    public ItemDTO toDto(){
        return ItemDTO.builder()
                .id(this.id)
                .name(this.name)
                .price(this.price)
                .build();
    }

    //수정을 위한 코드
    public void update(Item item){
        this.id = item.id;
        this.name = item.name;
        this.price = item.price;
    }
}
