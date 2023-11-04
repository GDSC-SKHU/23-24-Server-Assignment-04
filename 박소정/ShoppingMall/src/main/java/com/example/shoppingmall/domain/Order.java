package com.example.shoppingmall.domain;

import com.example.shoppingmall.dto.CustomerDto;
import com.example.shoppingmall.dto.ItemDto;
import com.example.shoppingmall.dto.OrderDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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

    @OneToMany // 중간 테이블 생성X, @OneToMany의 프록시(객체를 DB에서 조회할 때, 연관관계의 엔티티 정보를 끌어오는 쿼리 발생 시점) 옵션 기본값은 Lazy Fetch
    @JoinColumn(name = "ORDER_CUSTOMERS")
    private List<Customer> customers = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "ORDER_ITEMS")
    private List<Item> items = new ArrayList<>();

    @Column(name = "ORDER_COUNT", nullable = false)
    private Integer count;

    public OrderDto toDto() {
        List<CustomerDto> customerDtos = customers.stream().map(Customer::toDto).toList();
        List<ItemDto> itemDtos = items.stream().map(Item::toDto).toList();
        return OrderDto.builder()
                .id(this.id)
                .customers(customerDtos)
                .items(itemDtos)
                .count(this.count)
                .build();
    }

    public void update(Order order) {
        this.id = order.id;
        this.count = order.count;
    }

    public List<Customer> getCustomers() {
        return Collections.unmodifiableList(customers); // unmodifiableList: 추가, 삭제행위 금지, 불변 뷰로 감싸서 반환
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }
}
