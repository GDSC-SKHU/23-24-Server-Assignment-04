package com.example.shoppingmall.domain;

import com.example.shoppingmall.dto.CustomerDto;
import com.example.shoppingmall.dto.ItemDto;
import com.example.shoppingmall.dto.OrderDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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

    @OneToOne // @OneToMany 어노테이션은 일반적으로 컬렉션 타입 (예: List, Set, Map 등)과 함께 사용되어야 하므로 onetoone으로 변경
    @JoinColumn(name = "ORDER_CUSTOMER", nullable = false)
    private Customer customer;


    @OneToOne
    @JoinColumn(name = "ORDER_ITEM", nullable = false)
    private Item item;

    @Column(name = "ORDER_COUNT", nullable = false)
    private Integer count;

    public OrderDto toDto() {
        CustomerDto customerDto = new CustomerDto();
        ItemDto itemDto = new ItemDto();
        return OrderDto.builder()
                .id(this.id)
                .customer(customerDto)
                .item(itemDto)
                .count(this.count)
                .build();
    }

    public void update(Order order) {
        this.id = order.id;
        this.count = order.count;
    }
}
