package com.gdsc.store.domain;

import com.gdsc.store.dto.OrderDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue
    @Column(name="ORDER_ID")
    private int id;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    public OrderDto toDto() {
        if(item != null && customer != null){
            return OrderDto.builder()
                    .id(this.id)
                    .customerName(customer.getName())
                    .itemName(item.getName())
                    .build();
        }
        return OrderDto.builder()
                .id(this.id)
                .build();
    }

}
