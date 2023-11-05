package com.example.jpa3.domain;

import com.example.jpa3.dto.OrderDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID", nullable = false)
    Integer id;

    @OneToOne
    @JoinColumn(name = "CUSTOMER_NAME", nullable = false)
    Customer customer;

    @OneToOne
    @JoinColumn(name = "ITEM_NAME", nullable = false)
    Item item;

    public OrderDto toDto(){
        if(customer!=null && item!=null){
            return OrderDto.builder()
                    .id(this.id)
                    .customerName(customer.getName())
                    .itemName(item.getName())
                    .build();
        }
        return null;
    }

    public void update(Order order){
        this.id = order.id;
        this.customer = order.customer;
        this.item = order.item;
    }
}